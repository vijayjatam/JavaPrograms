package com.kali.kali;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by mpalavelli on 01-12-2017.
 */
public class PrepareHZQueryInput {
    public static void main(String[] args) {
        /**
         *
         * testType : XcrAPReport_1 ~ queryId : getXCRAPReport ~ pv_viewable_mode : N ~ pv_is_vwbl_demo_flg :  ~ pv_sort_order : DemoRank$true$true ~ pv_demo_type : -1
         * ~ pv_imponly_mode : N ~ pv_creative_type : -1 ~ deployScenario : HC ~ pv_geo_ids : 1001 ~ pv_geo_id : 1001 ~ pv_demo_ids :  ~ pv_user_type : I
         * ~ pv_dim_media_pln_ids :  -1 ~ pv_dev_typ : 1 ~ IS_EXPERIAN_DEMO : N ~ pv_cmpg_id : 600568757 ~ pv_is_ott_flag : Y ~ pv_end_dt_dt : 02-Jul-2017 ~ pv_all_cmpg : N
         * ~ pv_request_id :  ~ dailyEstimates : N ~ pv_requested_stats : xcr ~ pv_locale : en_US ~ requestedStats :  ~ queryName : getXCRAPReport ~ pv_clct_strt_dt : 18-Dec-2016
         * ~ pv_reporting_frequency : 100 ~ pv_start_dt_dt : 26-Jun-2017 ~ pv_is_tar_mobile_flag : Y ~ pv_tsv_cd : 4 ~ pv_dev_selection : 11,12,13,14
         *
         *
         * */

        File file = new File("C:/Users/mpalavelli/Desktop/OutFile.txt");

        String queryName = "getXCRAPReport";//"getXCRAPReport"; // getXCRReachByAgeAndGender

        String[] demos = {" ","1000","1003","1004","1005","1006","1007","1008","1009","1010","1011","1012","2000","2003","2004",
                "2005","2006","2007","2008","2009","2010","2011","2012"};
        //String[] demos = {" ","F$1000,F$1003,F$1004,M$2005,M$2006,M$2007"};


        String[] sites = {"-1","255974901","197774898","7874901","601477198","601736258","601695628","299674897","601567786","9974897","268074898","267374899","-1","5774897",
                "601698661","5874902","600396534","27574897","295508","12774897","271674900","4074992","6674908","601707736","142674897","601703251","601466202","4374995",
                "4074990","601574471","7974897","417515","601080260","601862959","7374900","4574995","15874902","92274936","601818016","4275000",""};

        String[] platforms = {"11,12,13,14","21,22,23,24,25,26,27,28","31,32,33,34"};

        String[] tsvCodes = {"4","8"};
        int testType = 1;
        String[] campaign = {"600568757"};
        StringBuilder sbuilder = new StringBuilder();
        for(int camp = 0; camp<campaign.length; camp++){
            for(int tsv=0;tsv<tsvCodes.length;tsv++){
                for(int demo=0;demo<demos.length;demo++){
                    Random r = new Random();
                    String  multDemo;
                    /*for(int i=1;i<=demos.length;i++){
                        multDemo =  (String) demos[r.nextInt(i - (demos.length-1)) + demos.length-1];
                    }*/


                    for(int site=0; site< sites.length; site++){
                        for(int plat=0; plat<platforms.length; plat++){
                            //sbuilder.append("XcrApTest_"+testType++ +"|"+ tsvCodes[tsv]+"|"+demos[demo]+"|"+sites[site]+"|"+platforms[plat]);
                            sbuilder.append("testType : "+queryName.replaceAll("get","")+"_"+testType++ +" ~ queryId : "+queryName+" ~ pv_viewable_mode : N ~ pv_is_vwbl_demo_flg : " +
                                    " ~ pv_sort_order : DemoRank$true$true ~ pv_demo_type : -1");
                            sbuilder.append(" ~ pv_imponly_mode : N ~ pv_creative_type : -1 ~ deployScenario : HC ~ pv_geo_ids : 1001 ~ pv_geo_id : 1001" +
                                    " ~ pv_demo_ids : "+demos[demo] +" ~ pv_user_type : I");
                            sbuilder.append(" ~ pv_dim_media_pln_ids :  "+sites[site]+" ~ pv_dev_typ : "+platforms[plat].charAt(0)+" ~ IS_EXPERIAN_DEMO : N ~ pv_cmpg_id : "+campaign[camp]+
                                    " ~ pv_is_ott_flag : Y ~ pv_end_dt_dt : 02-Jul-2017 ~ pv_all_cmpg : N");
                            sbuilder.append(" ~ pv_request_id :  ~ dailyEstimates : N ~ pv_requested_stats : xcr ~ pv_locale : en_US ~ requestedStats :  ~ queryName : getXCRAPReport"+queryName +
                                    " ~ pv_clct_strt_dt : 18-Dec-2016 ~ pv_reporting_frequency : 100 ~ pv_start_dt_dt : 26-Jun-2017 ~ pv_is_tar_mobile_flag : Y ~ pv_tsv_cd : "+tsvCodes[tsv] +
                                    " ~ pv_dev_selection : "+platforms[plat]);
                            sbuilder.append("\n");
                        }
                    }
                }
            }
        }
        FileWriter fw = null;
        try {
             fw= new FileWriter(file);
            fw.write(sbuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw!=null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
