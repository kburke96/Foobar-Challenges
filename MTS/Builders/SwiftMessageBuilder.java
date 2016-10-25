package Builders;

import Mts.impl.SwiftMessage;

public class SwiftMessageBuilder {

    public static SwiftMessage getMessage()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4::99:111:20:8861198070612345:23B:CRED:32A:000612USD5443,99:33B:USD5443,99:50K:GIAN ANGELO IMPORTSNAPLES:52A:BCITITMM500:53A:BCITUS33:54A:IRVTUS3N:57A:BNPAFRPPGRE:59:/20041010050500001M02606KILLY S.A.GRENOBLE:70:/RFB/INVOICE 559661:71A:SHA} ");
    }

    public static SwiftMessage getTestMessage(String currencyCode)
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4::99:222:20:8861198070612345:23B:CRED:32A:000612" + currencyCode + "5443,99:33B:USD5443,99:50K:GIAN ANGELO IMPORTSNAPLES:52A:BCITITMM500:53A:BCITUS33:54A:IRVTUS3N:57A:BNPAFRPPGRE:59:/20041010050500001M02606KILLY S.A.GRENOBLE:70:/RFB/INVOICE 559661:71A:SHA} ");
    }

    /**
     * Used in Node 6 Repair tests
     *
     */
    public static SwiftMessage getNode6BadSendersReferenceTestMessage1()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:1"   //this field needs repair
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadSendersReferenceTestMessage2()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:*&!1198070612345"    //this field needs repair
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadBankOperationCodeTestMessage1()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CR"     //this field needs repair
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadBankOperationCodeTestMessage2()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:!RED"   //this field needs repair
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadDateTestMessage1()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:0006USD5443,99"     //this field needs repair
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadDateTestMessage2()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612U!D5443,99"       //this field needs repair
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadOrderingCustomerTestMessage1()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEEFFFFFFFFFF"   //this field needs repair
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadOrderingCustomerTestMessage2()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:G12N ANGELO IMPORTSNAPLES"      //this field needs repair
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadBeneficiaryCustomerTestMessage()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEEFFFFFFFFFF"    //this field needs repair
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadDetailsOfChargesTestMessage1()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:S} ");      //this field needs repair
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6BadDetailsOfChargesTestMessage2()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:8861198070612345"
                + ":23B:CRED"
                + ":32A:000612USD5443,99"
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:!*A} ");    //this field needs repair
    }

    /**
     * Used in Node 6 tests
     *
     */
    public static SwiftMessage getNode6MultipleBadFieldsTestMessage()
    {
        return new SwiftMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4:"
                + ":99:111"
                + ":20:1"   //this field needs repair
                + ":23B:CR" //this field needs repair
                + ":32A:0006USD5443,99" //this field needs repair
                + ":33B:USD5443,99"
                + ":50K:GIAN ANGELO IMPORTSNAPLES"
                + ":52A:BCITITMM500"
                + ":53A:BCITUS33"
                + ":54A:IRVTUS3N"
                + ":57A:BNPAFRPPGRE"
                + ":59:/20041010050500001M02606KILLY S.A.GRENOBLE"
                + ":70:/RFB/INVOICE 559661"
                + ":71A:SHA} ");
    }

}
