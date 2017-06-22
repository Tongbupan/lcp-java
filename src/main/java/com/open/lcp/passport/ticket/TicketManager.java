package com.open.lcp.passport.ticket;

import com.open.common.enums.UserType;
import com.open.lcp.passport.PassportException;

public interface TicketManager {

	public Ticket createSecretKeyCouple(int appId, Long userId) throws PassportException;

	public Ticket createSecretKeyCouple2(UserType userType, int appId, Long userId) throws PassportException;

	public Ticket decodeTicket(String t) throws PassportException;

}
