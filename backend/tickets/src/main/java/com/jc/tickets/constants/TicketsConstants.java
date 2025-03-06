package com.jc.tickets.constants;

import com.jc.common.constants.CommonConstants;

public class TicketsConstants implements CommonConstants {
    private TicketsConstants() {
    }

    public static final String STATUS_500 = "500";
    public static final String FAILED_TO_BOOK_TICKET = "Failed to book ticket";
    public static final String TICKET_BOOKED_SUCCESSFULLY = "Ticket booked successfully";
    public static final String TICKET_NOT_FOUND = "Ticket not found";

    public static final String RESOURCE_TICKET = "Ticket";

    public static final String FIELD_TIC_UUID = "ticket id";
    public static final String FIELD_CUS_UUID = "customer id";
    public static final String FIELD_EVE_UUID = "event id";
    public static final String FIELD_SEA_UUID = "seat id";
    public static final String FIELD_PAYMENT_STATUS = "payment status";
    public static final String FIELD_PURCHASE_DATE = "purchase date";

}
