package com.example.infs3605_group_project.activities;

import com.google.gson.annotations.SerializedName;

public class SectorPerformanceAPI {



    public MetaData getMetaData() {
        return metaData;
    }

    public RealTime getReal_Time_PerformanceaData() {
        return Real_Time_PerformanceaData;
    }

    public Day1 getDay1() {
        return day1;
    }

    public Day5 getDay5() {
        return day5;
    }

    public Month1 getMonth1() {
        return month1;
    }

    public Month3 getMonth3() {
        return month3;
    }

    public YeartoDate getYeartoDate() {
        return yeartoDate;
    }

    public Year1 getYear1() {
        return year1;
    }

    public Year3 getYear3() {
        return year3;
    }

    public Year5 getYear5() {
        return year5;
    }

    public Year10 getYear10() {
        return year10;
    }

    @SerializedName("Meta Data")
    private MetaData metaData;

    @SerializedName("Rank A: Real-Time Performance")
    private RealTime Real_Time_PerformanceaData;

    @SerializedName("Rank B: 1 Day Performance")
    private Day1 day1;

    @SerializedName("Rank C: 5 Day Performance")
    private Day5 day5;

    @SerializedName("Rank D: 1 Month Performance")
    private Month1 month1;

    @SerializedName("Rank E: 3 Month Performance")
    private Month3 month3;

    @SerializedName("Rank F: Year-to-Date (YTD) Performance")
    private YeartoDate yeartoDate;

    @SerializedName("Rank G: 1 Year Performance")
    private Year1 year1;

    @SerializedName("Rank H: 3 Year Performance")
    private Year3 year3;

    @SerializedName("Rank I: 5 Year Performance")
    private Year5 year5;

    @SerializedName("Rank J: 10 Year Performance")
    private Year10 year10;


    public class Day5 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Month1 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Month3 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class YeartoDate {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Year1 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Year3 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Year5 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class Year10 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }
    public class Day1 {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;

    }

    public class MetaData {

        private String Information;

        public String getInformation() {
            return Information;
        }

        public String getLastRefreshed() {
            return lastRefreshed;
        }

        @SerializedName("Last Refreshed")
        private String lastRefreshed;
    }
    public class RealTime {
        public String getInformationTech() {
            return informationTech;
        }

        public String getEnergy() {
            return Energy;
        }

        public String getUtilities() {
            return Utilities;
        }

        public String getCommServices() {
            return commServices;
        }

        public String getConsumerDis() {
            return consumerDis;
        }

        public String getMaterials() {
            return Materials;
        }

        public String getIndustrials() {
            return Industrials;
        }

        public String getFinancials() {
            return Financials;
        }

        public String getRealestate() {
            return realestate;
        }

        public String getHealthcare() {
            return healthcare;
        }

        @SerializedName("Information Technology")
        private String informationTech;
        private String Energy;
        private String Utilities;
        @SerializedName("Communication Services")
        private String commServices;
        @SerializedName("Consumer Discretionary")
        private String consumerDis;
        private String Materials;
        private String Industrials;
        private String Financials;
        @SerializedName("Real Estate")
        private String realestate;
        @SerializedName("Health Care")
        private String healthcare;


    }

}
