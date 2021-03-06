package br.com.samples.samplemockito.model;


import java.util.ArrayList;
import java.util.List;

public class Job {
    private String mName;
    private String mDescription;
    private List<Employer> mEmployers;

    public Job( String mName, String description ) {
        this.mName = mName;
        this.mDescription = description;

        this.mEmployers = new ArrayList<>();
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

    public boolean hireEmployer( Employer employer ) {
        int qtdBeforeHire = countEmployers();

        employer.setJob( this );

        this.mEmployers.add( employer );

        int qtdAfterHire = countEmployers();

        return qtdBeforeHire != qtdAfterHire;

    }

    public void dismissEmployer( Employer employer ) {
        this.mEmployers.remove( employer );
    }

    public int countEmployers() {
        return this.mEmployers.size();
    }

    public String listAllEmployers() {
        StringBuilder builder = new StringBuilder( "Employers:{" );

        for( Employer employer : mEmployers ) {
            builder.append( "[name( " + employer.getName() + " ); " );
            builder.append( "age( " + employer.getAge() + " )];" );
        }

        builder.append( "}" );

        return builder.toString();
    }
}
