package com.open.messagebus.kafka;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.google.gson.Gson;
import com.mangocity.zk.ConfigChangeListener;
import com.mangocity.zk.ConfigChangeSubscriber;
import com.mangocity.zk.ZkConfigChangeSubscriberImpl;
import com.open.env.finder.ZKFinder;

public class KafkaConsumerXFactory {

	// private static final Log logger = LogFactory.getLog(SSDBXFactory.class);

	private static final Map<String, KafkaConsumerXImpl<String, String>> kafkaxMap = new ConcurrentHashMap<String, KafkaConsumerXImpl<String, String>>();

	private static final Object LOCK_OF_NEWPATH = new Object();

	static KafkaConsumerX<String, String> getKafkaConsumerX(final String instanceName,
			final KafkaMessageExecutor<String, String> executor) {

		final String ssdbZkRoot = ZKFinder.findSSDBZKRoot();
		KafkaConsumerXImpl<String, String> producer = kafkaxMap.get(instanceName);
		if (producer == null) {
			synchronized (LOCK_OF_NEWPATH) {
				ZkClient zkClient = new ZkClient(ZKFinder.findZKHosts(), 10000, 10000, new ZkSerializer() {

					@Override
					public byte[] serialize(Object paramObject) throws ZkMarshallingError {
						return paramObject == null ? null : paramObject.toString().getBytes();
					}

					@Override
					public Object deserialize(byte[] paramArrayOfByte) throws ZkMarshallingError {
						return new String(paramArrayOfByte);
					}
				});

				ConfigChangeSubscriber sub = new ZkConfigChangeSubscriberImpl(zkClient, ssdbZkRoot);
				sub.subscribe(instanceName, new ConfigChangeListener() {

					@Override
					public void configChanged(String key, String value) {

						ZKKafkaConsumerConfig consumerConfig = loadKafkaConsumerConfig(value);
						kafkaxMap.get(instanceName).getKafkaConsumerHolder().setConsumerConfig(consumerConfig);

					}
				});
				// String initValue = sub.getInitValue(source);

				// {"ip":"123.57.204.187","port":"8888","timeout":"200","cfg":{"maxActive":"100","testWhileIdle":true}}
				ZKKafkaConsumerConfig consumerConfig = loadKafkaConsumerConfig(zkClient, ssdbZkRoot, instanceName);
				kafkaxMap.put(instanceName, new KafkaConsumerXImpl<String, String>(consumerConfig) {
					@Override
					public void doMessage(ConsumerRecord<String, String> consumerRecord) {
						executor.doMessage(consumerRecord);
					}
				});
			}
		}

		return kafkaxMap.get(instanceName);
	}

	private static ZKKafkaConsumerConfig loadKafkaConsumerConfig(ZkClient zkClient, String ssdbZkRoot, String key) {
		String kafkaStr = zkClient.readData(ssdbZkRoot + "/" + key);
		return loadKafkaConsumerConfig(kafkaStr);
	}

	private static ZKKafkaConsumerConfig loadKafkaConsumerConfig(String jsonStr) {
		Gson gson = new Gson();
		ZKKafkaConsumerConfig zkKafkaConfig = gson.fromJson(jsonStr, ZKKafkaConsumerConfig.class);
		return zkKafkaConfig;
	}

}
