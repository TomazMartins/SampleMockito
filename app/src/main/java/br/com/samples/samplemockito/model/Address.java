package br.com.samples.samplemockito.model;


public class Address {
    private String mCity;
    private String mState;
    private String mCountry;

    public Address( String city, String state, String country ) {
        this.mCity = city;
        this.mState = state;
        this.mCountry = country;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity( String city ) {
        this.mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState( String state ) {
        this.mState = state;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry( String country ) {
        this.mCountry = country;
    }
}
