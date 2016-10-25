package Builders;

import Eps.impl.EpasMessage;

public class EpasMessageBuilder {

    public static EpasMessage getMessageCh1()
    {
        return new EpasMessage("<Document><Card><PAN>43111234567890</PAN><ExpiryDate>1116</ExpiryDate><EffectiveDate>1114</EffectiveDate></Card><Txn><Amt>1000</Amt><CurCodeAlpha>USD</CurCodeAlpha><CurCodeNum>840</CurCodeNum><Type>PURC</Type></Txn></Document>");
    }
    
    public static EpasMessage getMessageCh2()
    {
        return new EpasMessage("8A4D7326EDBF362704C9A18364D46D342C2F3C98DE9D82399637FAEBBB2B8D556171593B165A14C990490D1A23DBE357C56E33D2C31A3C8EF6E006A84863B36935FBBE6D967DCD73EF26EDB0AFDFF6EA2D75B90C51D35E047AC84BE2A53F7ACD04D320DEC6ADCB1955D4F722B76BE2B00392E408CA8FC5210554DEAAE42229B6A767B745EE671076474896EEAA0CB41905C1D5F2CBCEBFE2017CCA0AAC623F9DD041ED58FF55B19BD2A9805D86386F457DFA68A78E09092F15D2AAFD647D1E6D19F46A507A998A7ED3643603943732A1C782691C73E66449422411F7B8AA7D636BBAF40AAE44A57675D18F1A34671952");
    }
    
    public static EpasMessage getMessageCh3()
    {
        return new EpasMessage("<Document><Card><PAN>43111234567890</PAN><ExpiryDate>1116</ExpiryDate><EffectiveDate>1114</EffectiveDate></Card><Txn><Amt>1000</Amt><CurCodeAlpha>USD</CurCodeAlpha><CurCodeNum>840</CurCodeNum><Type>PURC</Type></Txn></Document><MAC>84A3808B19C897EE</MAC>");
    }
    
    public static EpasMessage getMessageCh4()
    {
        return new EpasMessage("<Document><Card><PAN>43111234567890</PAN><PINBlock>041205EEDCBA9876</PINBlock><ExpiryDate>1116</ExpiryDate><EffectiveDate>1114</EffectiveDate></Card><Txn><Amt>1000</Amt><CurCodeAlpha>USD</CurCodeAlpha><CurCodeNum>840</CurCodeNum><Type>PURC</Type></Txn></Document><MAC>84A3808B19C897EE</MAC>");
    }

    public static EpasMessage getTestMessage(String currencyCode)
    {
        return new EpasMessage("{1:F01MIDLGB22AXXX0548034693}{2:I103BKTRUS33XBRDN3}{3:{108:MT103}}{4::20:8861198070612345:23B:CRED:32A:000612" + currencyCode + "5443,99:33B:USD5443,99:50K:GIAN ANGELO IMPORTSNAPLES:52A:BCITITMM500:53A:BCITUS33:54A:IRVTUS3N:57A:BNPAFRPPGRE:59:/20041010050500001M02606KILLY S.A.GRENOBLE:70:/RFB/INVOICE 559661:71A:SHA} ");
    }

}
