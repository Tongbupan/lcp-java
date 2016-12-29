package com.open.lcp.core.api.command;

import com.open.lcp.core.api.entity.ApiResult;

/**
 * ����ӿ�
 */
public interface ApiCommand {

	/**
	 * Execute the command and return result
	 * 
	 * @param context
	 * @return
	 */
	ApiResult execute(ApiCommandContext context);

}
