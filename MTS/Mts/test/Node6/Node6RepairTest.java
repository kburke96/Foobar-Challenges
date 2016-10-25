/*********************************************************************************************************************************
 * Copyright (c) 2010 - 2030 by ACI Worldwide Inc. 6060 Coventry Drive, Omaha, Nebraska, 68022-6482, U.S.A. All rights reserved.
 *
 * This software is the confidential and proprietary information of ACI Worldwide Inc ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered
 * with ACI Worldwide Inc.
 ********************************************************************************************************************************/

package Mts.test.Node6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Builders.SwiftMessageBuilder;
import Mts.impl.Node6Impl;

/**
 * Node6 ('repair') test cases
 * @author costellode
 *
 */
public class Node6RepairTest {

    @Test
    public void testRepairBadSendersReference1() {
        Node6Impl test = new Node6Impl();
        // Pass in a SwiftMessage with a bad Senders Reference field and check does it get repaired
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadSendersReferenceTestMessage1()).getSendersReferenceCode()), "8861198070612345");
    }

    @Test
    public void testRepairBadSendersReference2() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadSendersReferenceTestMessage2()).getSendersReferenceCode()), "8861198070612345");
    }

    @Test
    public void testRepairBadBankOperationCode1() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadBankOperationCodeTestMessage1()).getBankOpenationCode()), "CRED");
    }

    @Test
    public void testRepairBadBankOperationCode2() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadBankOperationCodeTestMessage2()).getBankOpenationCode()), "CRED");
    }

    @Test
    public void testRepairBadDateCurrencyAmount1() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadDateTestMessage1()).getDateCurencyAmount()), "000612USD5443,99");
    }

    @Test
    public void testRepairBadDateCurrencyAmount2() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadDateTestMessage2()).getDateCurencyAmount()), "000612USD5443,99");
    }

    @Test
    public void testRepairBadOrderingCustomer1() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadOrderingCustomerTestMessage1()).getOderingCustomer()), "GIAN ANGELO IMPORTSNAPLES");
    }

    @Test
    public void testRepairBadOrderingCustomer2() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadOrderingCustomerTestMessage2()).getOderingCustomer()), "GIAN ANGELO IMPORTSNAPLES");
    }

    @Test
    public void testRepairBadBeneficiaryCustomer() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadBeneficiaryCustomerTestMessage()).getBeneficiaryCustomer()), "/20041010050500001M02606KILLY S.A.GRENOBLE");
    }

    @Test
    public void testRepairBadDetailsOfCharges1() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadDetailsOfChargesTestMessage1()).getDetailsOfCharges()), "SHA");
    }

    @Test
    public void testRepairBadDetailsOfCharges2() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6BadDetailsOfChargesTestMessage2()).getDetailsOfCharges()), "SHA");
    }

    @Test
    public void testRepairMultipleBadFields() {
        Node6Impl test = new Node6Impl();
        assertEquals((test.repair(SwiftMessageBuilder.getNode6MultipleBadFieldsTestMessage()).getSendersReferenceCode()), "8861198070612345");
        assertEquals((test.repair(SwiftMessageBuilder.getNode6MultipleBadFieldsTestMessage()).getBankOpenationCode()), "CRED");
        assertEquals((test.repair(SwiftMessageBuilder.getNode6MultipleBadFieldsTestMessage()).getDateCurencyAmount()), "000612USD5443,99");
    }

}
