package br.com.samples.samplemockito.model;


import java.util.List;

public class Job {
    private String mName;
    private String mDescription;
    private List<Employer> mEmployers;

    public Job( String mName, String description ) {
        this.mName = mName;
        this.mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName( String name ) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription( String mDescription ) {
        this.mDescription = mDescription;
    }

    public List<Employer> getEmployers() {
        return mEmployers;
    }

    public void setEmployers( List<Employer> employers ) {
        this.mEmployers = employers;
    }

    public void addEmployer( Employer employer ) {
        this.mEmployers.add( employer );
    }

    public void dismissEmployer( Employer employer ) {
        this.mEmployers.remove( employer );
    }

    public int countEmployers() {
        return this.mEmployers.size();
    }
}
