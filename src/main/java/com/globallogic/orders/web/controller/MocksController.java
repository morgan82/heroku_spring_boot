package com.globallogic.orders.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author facundo.ferro
 */
@RestController
@RequestMapping("/api")
public class MocksController {

    private static final Logger log = LoggerFactory.getLogger(MocksController.class);

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    @RequestMapping(value="/partners",method={RequestMethod.POST},  produces = "application/xml")
    public @ResponseBody  String partnersPost()
    {
    	if (getRandomBoolean()) 
    		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><PrtrOnboardResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">   <Version>1.0</Version>   <CorrelationId>00000060616</CorrelationId>   <RespCd>RCPOB000</RespCd>   <RespDesc>Congratulations. your request for becoming a partner has been successfully received.</RespDesc></PrtrOnboardResponse>";
    	else
    	{
    	    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    @RequestMapping(value="/partners/{partner_id}/campaign/{campaign_id}",method={RequestMethod.GET},  produces = "application/xml")
    public String partnersGET()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GetCmpgnResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>msg999999999</CorrelationId>    <RespCd>RCCPB000</RespCd>    <RespDesc>Request processed successfully.</RespDesc>   <CmpgnRecord>        <CmpgnId>201001708</CmpgnId>        <CmpgnNm>Janie's Offer</CmpgnNm>        <CMDiscType>F</CMDiscType>       <CMDisc>53.00</CMDisc>        <ActualSEDisc>53.00</ActualSEDisc>        <FundSEDisc>0.00</FundSEDisc>        <MinTransAmt>175.00</MinTransAmt>        <MaxTransAmt>9999999999999.99</MaxTransAmt>        <CmpgnStartDt>11/11/2013</CmpgnStartDt>        <CmpgnEndDt>11/12/2013</CmpgnEndDt>        <RedemptionFreq>1</RedemptionFreq>        <StmtCrLineDisc>Statement Credit</StmtCrLineDisc>        <StmtCrLineDiscReversal>Credit Reversal</StmtCrLineDiscReversal>        <CmpgnType>F</CmpgnType>        <MinCumulativeSpendThldAmt>0.00</MinCumulativeSpendThldAmt>        <MinCumulativeFreqThldCnt>1</MinCumulativeFreqThldCnt>        <CmpgnDispStartDt>2013-11-11-00.00.00.000000</CmpgnDispStartDt>        <CmpgnDispEndDt>2013-11-12-00.00.00.000000</CmpgnDispEndDt>        <EnrollCap>99999998</EnrollCap>        <EnrollCnt>0</EnrollCnt>        <DistrChan>            <DistrChanId>2</DistrChanId>            <RCTermsConditions>DINING POID AQJ:1Test Offer not valid for online purchases. If you order an item during the offer period but it is not sent to you until after the offer end date, it will not count towards determining whether your purchase qualifies for the offer. Limit 1 statement credit per American Express Card across all American Express offer channels. Statement credit will appear on your billing statement within 8 weeks after American Express receives information from the merchant about your qualifying purchase. Note that American Express may not receive information about your qualifying purchase from the merchant until all of the items from your qualifying purchase have been provided or shipped by the merchant. Statement credit may be reversed if qualifying purchase is returned/cancelled. If American Express does not receive information that identifies your transaction as qualifying for the offer, you will not receive the statement credit.  For example, your transaction will not qualify if it is not made directly with the merchant.  In addition, in most cases, you will not receive the statement credit if your transaction is made with an electronic wallet or through a third party or if the merchant uses a mobile or wireless card reader to process it.  Program Terms and Conditions apply; see below for details.  Click the 'Add to Card' button and use your synced American ExpressÂ® Card to redeem this offer today!</RCTermsConditions>        </DistrChan>    </CmpgnRecord></GetCmpgnResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    
    @RequestMapping(value="/partners/{partner_id}/campaign-report",method={RequestMethod.GET},  produces = "application/xml")
    public String partners2GET()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ReportResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>123456</CorrelationId>    <RespCd>RCREP000</RespCd>    <RespDesc>Report request processed successfully.</RespDesc>    <RecCnt>0</RecCnt>    <RptRecord id=\"1\">        <RptCreatDt>12/03/2015</RptCreatDt>        <CmpgnId>666777333</CmpgnId>        <CmpgnName>S3 AU OFFER</CmpgnName>        <CmpgnType></CmpgnType>        <CmpgnstDt>2014-07-01</CmpgnstDt>        <CmpgnEndDt>2014-09-02</CmpgnEndDt>        <TransactionDts>            <TotDiscAmt>999999999999.99</TotDiscAmt>            <TotEnroll>25</TotEnroll>            <TotDisc>9999</TotDisc>            <RedemptionRt>999.90</RedemptionRt>            <RedemptionChrgeVol>999999999999.99</RedemptionChrgeVol>            <TotTrans>9999</TotTrans>            <ChrgVol>999999999999.99</ChrgVol>            <AvgROCAmt>999999999999.99</AvgROCAmt>            <Enrollcap>9999</Enrollcap>            <MaxAwardCap>999999999999.99</MaxAwardCap>            <RdmptChrgeVolEqToLcalCurr>999999999999</RdmptChrgeVolEqToLcalCurr>            <AvgTrasnFreq>99999.99</AvgTrasnFreq>            <CtryCd></CtryCd>            <CtryCdDesc></CtryCdDesc>            <CurrCd>840</CurrCd>            <CurrDesc></CurrDesc>        </TransactionDts>        <MerchantDetails id=\"1\">            <MerchantId>1234</MerchantId>            <SENumber>5020873907</SENumber>            <SEIMSIndustryCd> </SEIMSIndustryCd>            <SEIMSIndustryDS> </SEIMSIndustryDS>            <GlblIndustryCd> </GlblIndustryCd>            <GlblIndustryDS> </GlblIndustryDS>            <TransactionDts>                <TotDiscAmt>999999999999.99</TotDiscAmt>                <TotDisc>9999</TotDisc>                <RedemptionChrgeVol>999999999999.99</RedemptionChrgeVol>                <TotTrans>9999</TotTrans>                <ChrgVol>999999999999.99</ChrgVol>                <AvgROCAmt>999999999999.99</AvgROCAmt>                <Enrollcap>9999</Enrollcap>                <MaxAwardCap>999999999999.99</MaxAwardCap>                <RdmptChrgeVolEqToLcalCurr>999999999999</RdmptChrgeVolEqToLcalCurr>                <AvgTrasnFreq>99999.99</AvgTrasnFreq>                <CtryCd></CtryCd>                <CtryCdDesc></CtryCdDesc>                <CurrCd></CurrCd>                <CurrDesc></CurrDesc>            </TransactionDts>        </MerchantDetails>        <DistChannelDetails id=\"1\">            <DistrChan>0</DistrChan>            <DistrChanDesc></DistrChanDesc>            <TransactionDts>                <TotDiscAmt>999999999999.99</TotDiscAmt>                <TotEnroll>9999</TotEnroll>                <TotDisc>9999</TotDisc>                <RedemptionRt>99.99</RedemptionRt>                <RedemptionChrgeVol>999999999999.99</RedemptionChrgeVol>                <TotTrans>9999</TotTrans>                <ChrgVol>999999999999.99</ChrgVol>                <AvgROCAmt>999999999999.99</AvgROCAmt>                <Enrollcap>9999</Enrollcap>                <MaxAwardCap>999999999999.99</MaxAwardCap>                <RdmptChrgeVolEqToLcalCurr>999999999999999</RdmptChrgeVolEqToLcalCurr>                <AvgTrasnFreq>9999.99</AvgTrasnFreq>                <CurrCd></CurrCd>                <CurrDesc></CurrDesc>            </TransactionDts>        </DistChannelDetails>        <SrcSystemNm>RC</SrcSystemNm>    </RptRecord></ReportResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    @RequestMapping(value="/cardmembers/{id}/social-enrollments",method={RequestMethod.POST}, produces = "application/xml")
    public String cardmembersPost()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CMPreEnrollResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>msgid371290043311008</CorrelationId>    <RespCd>RCCMP000</RespCd>    <RespDesc>Card member successfully enrolled.</RespDesc>    <CMAlias1>alias374320000001651</CMAlias1></CMPreEnrollResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }

    
    @RequestMapping(value="/cardmembers/offer-enrollments",method={RequestMethod.POST},  headers ="Accept=application/json")
    public String cardmembers2Post()
    {
    	if (getRandomBoolean()) 
    return "{   \"enrollmentResponseData\": {      \"cardNbr\": \"371539205511007\",      \"voucherChannel\": \"\",      \"voucherValue\": \"\",      \"enrollCap\": \"20\",      \"enrolledCount\": \"8\",      \"cmAlias1\": \"\"   },   \"msgID\": \"123\",   \"responseCode\": \"NGENR000\",   \"responseMsg\": \"CM successfully enrolled.\"}";
    	else
    	{
    return "{   \"enrollmentResponseData\": \"error\" }";
    	}
    }
    
    @RequestMapping(value="/cardmember/airline-selection",method={RequestMethod.POST},  produces = "application/xml")
    public String cardmembers3Post()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SelectAirlineResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>14c4c400-d115-4009-b</CorrelationId>    <Errors>        <ErrDtls>            <ErrType>Application Error</ErrType>            <ErrCd>RCAFC023</ErrCd>            <ErrMsg>CARD MEMBER DETAILS NOT FOUND</ErrMsg>        </ErrDtls>    </Errors></SelectAirlineResponse>";

    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    @RequestMapping(value="/cardmembers/{id}/social-enrollments",method={RequestMethod.DELETE}, produces = "application/xml")
    public String cardmembersDelete()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><UnSyncCMResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">   <Version>1.0</Version>   <CorrelationId>madan</CorrelationId>   <RespCd>RCCMU000</RespCd>   <RespDesc>Card member successfully unsynced.</RespDesc>   <UserId>rat</UserId></UnSyncCMResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    
    @RequestMapping(value="/cardmembers/offer-savings",method={RequestMethod.GET},  produces = "application/xml")
    public String cardmembers2GET()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OfferSavingsResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <RespCd>RCCSV001</RespCd>    <RespDesc>Successful</RespDesc>    <TotalOfferSavings>2,222,222</TotalOfferSavings></OfferSavingsResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    @RequestMapping(value="/cardmembers/offer-savigns", params = "history=y",method={RequestMethod.GET},  headers ="Accept=application/json")
    public String cardmembers3GET()
    {
    	if (getRandomBoolean()) 
    return "{   \"savingsdet\": {\"offrSavings\": []},   \"version\": \"1.0\",   \"correlationId\": \"msgid375172003924119\",   \"respCd\": \"RCSAV000\",   \"respDesc\": \"Record retreival successful                                                                         \"}";
//    		"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OfferSavingsResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <RespCd>RCCSV001</RespCd>    <RespDesc>Successful</RespDesc>    <TotalOfferSavings>2,222,222</TotalOfferSavings></OfferSavingsResponse>";
    	
    	else
    	{
    		return "{   \"enrollmentResponseData\": \"error\" }";
    	}
    }
    
    @RequestMapping(value="/cardmembers/offer-enrollments",method={RequestMethod.GET}, produces = "application/xml")
    public String cardmembersGET()
    {
    	if (getRandomBoolean()) 
    return "{   \"enrollStatusCSV\": \"378790314012006:Not Enrolled:N/A\",   \"version\": \"1.0\",   \"correlationId\": \"msgid375172003924119\",   \"respCd\": \"RC0000\",   \"respDesc\": \"Enrollment statuses successfully fetched.\"}";
    	else
    	{
    		return "{   \"enrollmentResponseData\": \"error\" }";
    	}
    }
    
    @RequestMapping(value="/offers",method={RequestMethod.POST},   produces = "application/xml")
    public @ResponseBody String offersPost()
    {
    	if (getRandomBoolean()) 
    return "<AddOfferResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">   <Version>1.0</Version>   <CorrelationId>4126356ee</CorrelationId>   <RespCd>RCCPA000</RespCd>   <RespDesc>Your request for adding an Campaign has been successfully received.</RespDesc>   <RCOfferId>299066769</RCOfferId>   <PrgmCd>SOE99</PrgmCd>   <PrgmTypeCd>814</PrgmTypeCd>   <ListEnrollSta id=\"000014894\">      <EnrollStaCd>RCMLA000</EnrollStaCd>      <EnrollStaDesc>MLE List Enrolled successfully.</EnrollStaDesc>   </ListEnrollSta></AddOfferResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    
    
    @RequestMapping(value="/offers/{id}", method={RequestMethod.PUT},  produces = "application/xml")
    public String offersPut()
    {
    	if (getRandomBoolean()) 
    return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><UpdtOfferResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>1433450661759</CorrelationId>    <RespCd>RCCPU000</RespCd>    <RespDesc>Campaign details updated successfully.</RespDesc>    <PrgmCd>SOE99</PrgmCd>    <PrgmTypeCd>814</PrgmTypeCd>    <ListEnrollSta id=\"000014894\">        <EnrollStaCd>RCMLU000</EnrollStaCd>        <EnrollStaDesc>MLE List Updated successfully. </EnrollStaDesc>    </ListEnrollSta></UpdtOfferResponse>";
    	else
    	{
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    
    @RequestMapping(value="/cardmembers/{id}/cardnumber", method={RequestMethod.GET},   produces = "application/xml")
    public String cardmemberGet()
    {
    	if (getRandomBoolean()) 
    		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CardNbrResponse xmlns=\"http://api.americanexpress.com/registeredcard/V1.0\">    <Version>1.0</Version>    <CorrelationId>MsgId377290746041005</CorrelationId>    <RespCd>RCCNR000</RespCd>    <RespDesc>Records fetched successfully.</RespDesc>    <CardNbrList>        <CardNbr>XXXXXXXXXXX1000</CardNbr>    </CardNbrList></CardNbrResponse>";
    	else
    	{
    		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    @RequestMapping(value="/cardmember/notification-enrollment", method={RequestMethod.POST},  produces = "application/xml")
    public String cardmemberPost()
    {
    	if (getRandomBoolean()) 
    		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <Version>1.0</Version> <CorrelationId>SDHSD22324</CorrelationId>  <RespCd>SOENR000</RespCd>  <RespDesc>Request processed successfully</RespDesc> </NotificationEnrollmentResponse>";
    	else
    	{
    		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <NotificationEnrollmentResponse xmlns=\"http://api.americanexpress.com/smartofferengine/V1.0\" >  <code>1</code> <description>2</description> </NotificationEnrollmentResponse>";
    	}
    }
    
    
}