package br.com.samples.samplemockito.model;


public class Employer {
    private String mName;
    private int mAge;
    private Job mJob;

    public Employer( String mName, int age ) {
        this.mName = mName;
        this.mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName( String name ) {
        this.mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge( int age ) {
        this.mAge = age;
    }

    public Job getJob() {
        return mJob;
    }

    public void setJob( Job job ) {
        this.mJob = job;
    }

    public String toString() {
        return "Employer:[name( " + this.mName + " ); age( " + this.mAge + " )]";
    }
}
