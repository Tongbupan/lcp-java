package com.open.lcp.core.api.entity;

/**
 * "E"��ʾ��error��(����)��"SYS"��ʾ"system"��ϵͳƽ̨���ģ�;"biz"��ʾ��business����ҵ�񼶵ģ�
 */
public final class ApiResultCode {

	/** �ɹ� **/

	public final static int SUCCESS = 0;

	/** С��1000��Ϊϵͳ���� **/

	public final static int E_SYS_UNKNOWN = 1;// ϵͳ�������

	public final static int E_SYS_PARAM = 2;// ��Ч���������

	public final static int E_SYS_PERMISSION_DENY = 3;// �û���Ȩ��

	public final static int E_SYS_REQUEST_TOO_FAST = 4;// �û���������Ƶ��

	public final static int E_SYS_RPC_ERROR = 5;// RPC error

	public final static int E_SYS_INVALID_APP_ID = 6;// ��Ч��app id

	public final static int E_SYS_INVALID_TICKET = 7;// ��Ч��ticket

	public final static int E_SYS_INVALID_SIG = 8;// ��Ч��ǩ��

	public final static int E_SYS_INVALID_VERSION = 9;// ��Ч�İ汾

	public final static int E_SYS_UNKNOWN_METHOD = 10;// δ֪�ӿ�����

	public final static int E_SYS_UNKNOWN_RESULT_FORMAT = 11;// δ֪�����ʽ

	public final static int E_SYS_RPC_NULL = 12;// �ײ����û���׳��쳣���������أ����صĽ��Ϊnull

	public final static int E_SYS_UNSUPPORTED_FILE_TYPE = 13;// ��֧�ֵ��ļ�����

	public final static int E_BIZ_BATCH_RUN_CYCLE_CALL = 14; // ������ʱ��ѭ��������

	public final static int E_SYS_FORCED_UPDATE = 15; // ǿֱ����

	public final static int E_SYS_FAULT_ISOLATION = 16; // �ӿ�����ϸ���

	public final static int E_SYS_TICKET_NOT_EXIST = 17; // û��tƱ

	public final static int E_SYS_LACKOF_REQUIRED_PARAM = 18;// ȱ��ѡ����
	public final static int E_SYS_RESP = 22;// ��Ч�ķ�������
	public final static int E_USER_TOO_FAST = 24;// �����û���Ƶ�أ��û���������Ƶ����

	/** ����1000��С��2000ΪAccountҵ�񼶴��� **/

	public final static int E_BIZ_ACCOUNT_LOGIN_ERROR = 1001;// ��½ʧ��

	public final static int E_BIZ_ACCOUNT_INVALID_USER = 1002;// ��½ʧ�ܣ����ʻ�������

	public final static int E_BIZ_ACCOUNT_WRONG_PWD = 1003;// ��½ʧ�ܣ����벻��ȷ

	public final static int E_BIZ_ACCOUNT_INVALID_AT = 1004; // ��Ч��access token

	public final static int E_BIZ_ACCOUNT_PROFILE_ERROR = 1005; // ���ֻ�����ʹ�ã�������ֻ��Ű�

	public final static int E_BIZ_ACCOUNT_QUAD_CONTACT_LIST_ERROR = 1006; // �û���δ���а���֤����

	public final static int E_BIZ_ACCOUNT_FB_CONTACT_LIST_ERROR = 1007; // ��֤�����

	public final static int E_BIZ_ACCOUNT_INVALID_QUAD_USER = 1008; // ������ʱ��ѭ��������

	public final static int E_BIZ_ACCOUNT_INVALID_FB_USER = 1009; // �����ڵ�Facebook�û�

	public final static int E_BIZ_ACCOUNT_EXCEED_CONTACT_NUMBER_LIMIT = 1010; // ���������ﵽ����

	public final static int E_BIZ_ACCOUNT_INVALID_CONTACT = 1011; // ���û����Ǳ��˵�Quad��ϵ��

	public final static int E_BIZ_ACCOUNT_DELETE_CONTACT_ERROR = 1012; // ɾ��Quad����ʧ��

	public final static int E_BIZ_ACCOUNT_GET_RECOMMEND_ERROR = 1013; // ɾ���Ƽ�����ʧ��

	public final static int E_BIZ_ACCOUNT_USER_BLOCKED = 1014; // �û��Ѿ�����ֹ��¼

	public final static int E_BIZ_ACCOUNT_MOBILE_REGISTERED = 1015; // ���ֻ����Ѿ���ע��

	public final static int E_BIZ_ACCOUNT_SEND_MOBILE_VERIFY_FAIL = 1016; // �ֻ���֤�뷢��ʧ��

	public final static int E_BIZ_ACCOUNT_SEND_MOBILE_VERIFY_EXCEED_LIMT = 1017; // �ֻ���֤�뷢�ʹ�������

	public final static int E_BIZ_ACCOUNT_BAD_MOBILE_VERIFY_CODE = 1018; // �ֻ���֤���������ѹ���

	public final static int E_BIZ_ACCOUNT_UNBIND_MOBILE_FAIL_NO_OTHERACCOUNT = 1019; // û��������Ч�ʺţ�����ֻ���ʧ��

	public final static int E_BIZ_ACCOUNT_UNBIND_FACEBOOK_FAIL_NO_OTHERACCOUNT = 1020; // û��������Ч�ʺţ����Facebook��ʧ��

	public final static int E_BIZ_ACCOUNT_FB_USER_REGISTERED = 1021; // �û��Ѿ�ע��

	public final static int E_BIZ_ACCOUNT_SEND_MOBILE_NUMBER_EXCEED_LIMIT = 1022; // ����Ŀ����ֻ�����������

	public final static int E_BIZ_ACCOUNT_FB_BIND_DUPLICATED = 1023; // ���û��Ѿ�����facebook�˺�

	public final static int E_BIZ_ACCOUNT_INVITE_TIMES_EXCEED_LIMIT = 1024; // �����������������������

	public final static int E_BIZ_ACCOUNT_SEND_SMS_FAIL = 1025; // ���ŷ���ʧ��

	public final static int E_BIZ_ACCOUNT_SEND_INVITE_FB_FAIL = 1026; // ����facebook����ʧ��

	/** ����2000��С��3000ΪFeedҵ�񼶴��� **/

	public final static int E_BIZ_FILE_TOO_LARGE_FILE = 2001;// �ϴ����ļ�̫��

	public final static int E_BIZ_FEED_UPLOAD_ERROR = 2002;// �ϴ��ļ�ʧ��

	public final static int E_BIZ_FEED_SELECT_USER_LIMIT = 2003;// ѡ����û�������������

	public final static int E_BIZ_FEED_WRONG_TYPE = 2004; // �����feed����

	public final static int E_BIZ_FEED_PUBLISH_FREQUENCY = 2005; // ����feed����

	public final static int E_BIZ_FEED_PUBLISH_ERROR = 2006; // ����feedʧ��

	public final static int E_BIZ_FEED_INVALID_ID = 2007; // �����ڵ�Feed ID

	public final static int E_BIZ_FEED_IGNORE_ERROR = 2008; // ����feedʧ��

	public final static int E_BIZ_FEED_QUIT_ERROR = 2009; // �˳�feedʧ��

	public final static int E_BIZ_FEED_DELETE_DUPLICATE = 2010; // ��ͼƬ��ɾ��

	public final static int E_BIZ_FEED_DELETE_PICTURE_ERROR = 2011;// ɾ��feedͼƬʧ��

	public final static int E_BIZ_FEED_GET_LIST_ERROR = 2012;// ��ȡfeed�б�ʧ��

	public final static int E_BIZ_FEED_WRONG_COMMENT_TYPE = 2013;// �������������

	public final static int E_BIZ_FEED_PUBLISH_COMMENT_FREQUENCY = 2014; // �������۹���

	public final static int E_BIZ_FEED_PUBLISH_COMMENT_ERROR = 2015; // ��������ʧ��

	public final static int E_BIZ_FEED_GET_CONMMENT_LIST_ERROR = 2016; // ��ȡ�����б�ʧ��

	public final static int E_BIZ_FEED_GUESS_NUMBER_LIMIT = 2017; // �µ�������������

	public final static int E_BIZ_FEED_CONFESS_DUPLICATE = 2018; // ��feed������

	public final static int E_BIZ_FEED_GUESS_DUPLICATE = 2019; // ���û��Ѳ¹���feed

	public final static int E_BIZ_FEED_GUESS_ERROR = 2020; // ��ʧ��

	public final static int E_BIZ_FEED_CONFESS_AUTHORITY = 2021; // �����ڱ��˵�feed������

	public final static int E_BIZ_FEED_CONFESS_ERROR = 2022; // ����ʧ��

	public final static int E_BIZ_FEED_GET_GUESS_STATUS_ERROR = 2023; // ��ȡ���˶�̬ʧ��

	public final static int E_BIZ_FEED_HAS_BEEN_DELETED = 2024; // �����feed�Ѿ���ɾ��

	public final static int E_BIZ_FEED_HAS_BEEN_DUMPED = 2025; // Feed�Ѿ�������

	public final static int E_BIZ_FEED_HAS_BEEN_UNDUMPED = 2026; // Feed�Ѿ���ȡ������

	public final static int E_BIZ_FEED_ONE_MEMBER = 2027; // ���ܷ���ֻ���Լ���Feed

	public final static int E_BIZ_FEED_TOO_LONG_TEXT = 2028; // ��feed�����۵��ı�����

	public final static int E_BIZ_FEED_HAS_NO_VOICE = 2029; // ��feedû����������

	/** ����3000��С��4000ΪMessageҵ�񼶴��� **/

	public final static int E_BIZ_MSG_INVALID_TYPE = 3001;// �������Ϣ����

	/** ����4000��С��5000ΪSystemҵ�񼶴��� **/

	public final static int E_BIZ_SYS_FEEDBACK_FREQUENCY = 4001;// �ύ��������

	public final static int E_BIZ_SYS_FEEDBACK_ERROR = 4002;// �ύ����ʧ��

	public final static int E_BIZ_SYS_SUE_DUPLICATE = 4003;// �Ѿٱ�����feed

	public final static int E_BIZ_SYS_SUE_ERROR = 4004;// �ٱ�ʧ��

	/** ����5000��С��6000ΪChatҵ�񼶴��� **/

	public final static int E_BIZ_CHAT_GROUP_MEMBER_EXCEED = 5001;// Ⱥ��Ա�����ﵽ����

	public final static int E_BIZ_CHAT_GROUP_MEMBER_INSUFFICIENT = 5002;// Ⱥ��Ա��������

	public final static int E_BIZ_CHAT_GROUP_CREATE_ERROR = 5003;// ��Ⱥʧ��

	public final static int E_BIZ_CHAT_GROUP_ADD_MEMBER_ERROR = 5004; // ���Ⱥ��Աʧ��

	public final static int E_BIZ_CHAT_GROUP_NOT_MEMBER = 5005; // �Ǳ�Ⱥ��Ա

	public final static int E_BIZ_CHAT_GROUP_NOT_EXIST = 5006; // �����ڵ�Ⱥ

	public final static int E_BIZ_CHAT_GROUP_EDIT_NAME_ERROR = 5007; // �༭Ⱥ��ʧ��

	public final static int E_BIZ_CHAT_MSG_SEND_ERROR = 5008; // ������Ϣʧ��

	public final static int E_BIZ_CHAT_GROUP_MUTE_ERROR = 5009; // ����Ⱥʧ��

	public final static int E_BIZ_CHAT_GROUP_UNMUTE_ERROR = 5010; // ȡ��Ⱥ����ʧ��

	public final static int E_BIZ_CHAT_GROUP_QUIT_ERROR = 5011; // ��Ⱥʧ��

	public final static int E_BIZ_CHAT_GROUP_FETCH_INFO_ERROR = 5012; // ��ȡȺ��Ϣʧ��

	public final static int E_BIZ_CHAT_GROUP_MEMBER_INFO_FETCH_ERROR = 5013; // ��ȡȺ��Ա��Ϣʧ��

	public final static int E_BIZ_CHAT_GROUP_MUTE_STATUS_ERROR = 5014; // ��ȡȺ����״̬ʧ��

	public final static int E_BIZ_CHAT_MSG_RECV_ERROR = 5015; // ������Ϣʧ��

	public final static int E_BIZ_CHAT_INIT_ERROR = 5016; // �����ʼ��ʧ��

	public final static int E_BIZ_CHAT_USER_MUTE_ERROR = 5017; // �����û�ʧ��

	public final static int E_BIZ_CHAT_USER_UNMUTE_ERROR = 5018; // ȡ�����û�������ʧ��

	public final static int E_BIZ_CHAT_MUTE_STATUS_ERROR = 5019; // ��ȡ����״̬ʧ��

	public final static int E_BIZ_CHAT_LBS_GROUP_NOT_EXIST = 5034; // Ⱥ������

	public final static int E_BIZ_EVENT_NOT_EXIST = 5036;// �����ڵ�event

	public final static int E_BIZ_EVENT_DELETE_NOT_OWNER = 5037;// ���Ǳ��˻�Ⱥ��ɾ��event

	public final static int E_BIZ_EVENT_DELETE_ERROR = 5038;// ɾ��eventʧ��

	public final static int E_BIZ_EVENT_ADD_MEMBER_ERROR = 5039;// ��ӳ�Աʧ��

	public final static int E_BIZ_EVENT_QUIT_ERROR = 5040;// �˳�eventʧ��

	//
	public final static int VIDEO_OPTION_FAILED = 8000;
	public final static int VIDEO_CHANNEL_HAS_CONFIGED = 8001;
	public final static int VIDEO_NOT_EXIST = 8002;

	public final static int USER_IN_BLACKLIST = 70008;
}
