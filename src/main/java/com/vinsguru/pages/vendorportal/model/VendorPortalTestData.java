package com.vinsguru.pages.vendorportal.model;

public class VendorPortalTestData {
    String username;
    String password;
    String monthlyEarningh;



    String annualEarning;
    String profitMargin;
    String searchKeyword;
    String searchResultsCounyt;

    public VendorPortalTestData(String username, String password, String monthlyEarningh, String annualEarning, String profitMargin, String searchKeyword, String searchResultsCounyt) {
        this.username = username;
        this.password = password;
        this.monthlyEarningh = monthlyEarningh;
        this.annualEarning = annualEarning;
        this.profitMargin = profitMargin;
        this.searchKeyword = searchKeyword;
        this.searchResultsCounyt = searchResultsCounyt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMonthlyEarningh() {
        return monthlyEarningh;
    }

    public String getAnnualEarning() {
        return annualEarning;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public String getSearchResultsCounyt() {
        return searchResultsCounyt;
    }
}

