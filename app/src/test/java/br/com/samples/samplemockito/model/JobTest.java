package br.com.samples.samplemockito.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JobTest {
    // Declaring a mock
    @Mock private Employer mockEmployer;
    @Mock private Address mockAddress;

    private Job validJob;

    @Before
    public void setUp() {
        // Initializing the mocks objects
        MockitoAnnotations.initMocks( this );

        validJob = new Job( "Android Developer", "BSB, DF, Brazil" );
    }

    @Test
    public void shouldHireAnEmployer() {
        /*
        * First use of the mocked object.
        *
        *   In here, we use the mock - mockEmployer - to
        *   replace an object Employer that would pass as
        *   a parameter to the method 'hireEmployer()'.
        * */
        assertThat( validJob.hireEmployer( mockEmployer ), is( true ) );
    }

    @Test
    public void shouldListAllEmployers() {
        /*
        * First use of the static method 'when()', of framework Mockito.
        *
        *   In here, we use the method 'when()'. This
        *    method allow us to CONFIGURE the mocked
        *    object.
        *
        *   So, method 'when()' receives as a parameter a
        *    method of the mocked object. After that, we
        *    use the method 'thenReturn()', to indicate
        *    what the behaviour of the Mockito must have.
        * */
        when( mockEmployer.getName() ).thenReturn( "Tom" );
        when( mockEmployer.getAge() ).thenReturn( 29 );

        validJob.hireEmployer( mockEmployer );

        assertThat( validJob.listAllEmployers(), is( "Employers:{[name( Tom ); age( 29 )];}" ) );

        /*
        * First use of the static method 'verify()', of framework Mockito.
        *
        *   In here, we use the method 'verify()'. This
        *    method allow us to VERIFY the calls of
        *    mocked object.
        *
        *   So, method 'verify()' receives the mocked
        *    object. After that, we call the method
        *    that we want track.
        * */
        verify( mockEmployer ).getName();
        verify( mockEmployer ).getAge();
    }

    @Test
    public void shouldReturnsCountryOfEmployer() {
        /*
        * In here we use the method 'when()', again.
        *
        *   But, this time, it's different. In here
        *    our goal is test the result of the
        *    method 'getCountry()' from the mocked
        *    object Employer.
        *
        *   But, for that, we must configure the return
        *    of the method 'getCountry()' first.
        *
        *   We do this and the return is 'Brazil'. But,
        *    with only this configuration it doesn't works.
        *    We receive a 'NullPointerException. Why?
        *
        *   We forgot a step: the return of method
        *   'getAddress()'. We use a mocked object.
        *   Because of this, we don't really have a object
        *   that has a method 'getAddress()' with a return.
        *
        *  We need configure this step too.
        *    So, it's the reason for we have to calls to
        *    method 'when()'.
        *
        *  The first one is to configure the return of the
        *   method 'getAddress()', that we set with a other
         *  mocked object, a mocked Address.
         *  the second, we configure the return of the
         *  'getCountry()'.
        * */
        when( mockEmployer.getAddress() ).thenReturn( mockAddress );
        when( mockEmployer.getAddress().getCountry() ).thenReturn( "Brazil" );

        validJob.hireEmployer( mockEmployer );

        assertThat( validJob.getEmployers().get( 0 ).getAddress().getCountry(), is( "Brazil" ) );
    }
}