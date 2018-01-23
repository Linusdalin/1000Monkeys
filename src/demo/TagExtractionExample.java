package demo;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/******************************************************************************
 *
 *          This is a mechanical turk example of the 1000Monkeys coder
 *
 */


public class TagExtractionExample {


    /************************************************************
     *
     *         The input is a unit test case. This defines the
     *         structure and the expected outcome of the class under test
     *
     *
     *          Here is a simple example:
     *
     */

    @Test
    public void getTagByNameTest(){

        TagExtractor tag = new TagExtractor("This is a text with a #TAG");
        assertThat("Tag name", tag.getTag(), is("#TAG"));
        assertThat(tag.isFound(), is(true));

    }


    /*****************************************************************
     *
     *          The most basic outcome is a class that follows the structure
     *          of the test
     *
     *          Here the constructor and methods are defined
     *
     *
     */


    class TagExtractor{

        public TagExtractor(String s) {

        }

        public String getTag() {
            return null;
        }

        public boolean isFound() {
            return false;
        }
    }


    /************************************************************************
     *
     *          Running the test with the generated class will however fail.
     *
     *          The next step is for the 1000 Monkey Bot to try to generate a class
     *          that will fulfill all the test cases
     *
     */


    class TagExtractor2{

        public TagExtractor2(String s) {

        }

        public String getTag() {
            return "#TAG";
        }

        public boolean isFound() {
            return true;
        }
    }


    /************************************************************************
     *
     *              Not very useful, but actually almost as much as the system
     *              can do with the information we did provide.
     *
     *              As we see, the system could suspect that it is falling short as it
     *              is not using the parameter passed in. What to do with it may however
     *              be a bit difficult. However, we could imagine a situation where it
     *              used it makes a qualified guess.
     *
     *              We do now however quickly understand that we need to
     *              provide more information through more test cases.
     *
     *
     */


    @Test
    public void getTagByNameTest2(){

        TagExtractor tag = new TagExtractor("This is a text without a TAG");
        assertThat("Tag name", tag.getTag(), is((String)null));
        assertThat(tag.isFound(), is(false));


    }

    /*************************************************************************
     *
     *          We run the 1000 Monkey Bot again and now we get more information out.
     *
     *
     *
     */



    class TagExtractor3{

        String s;                                               // Hackerbot can't provide semantically good names

        public TagExtractor3(String s) {
            this.s = s;                                         // Store to reuse
        }

        public String getTag() {

            if(isFound())
                return "#tag";                                  // Still hard coded static
            return null;
        }

        public boolean isFound() {

            return s.indexOf("#tag") >= 0;
        }
    }

    /************************************************************************'
     *
     *      So how can we get to this point.
     *
     *      There are two main principles here:
     *
     *        - Use programming strategies. In this example, there is a relationship between
     *          text string s and the output, so we apply a pattern of storing it
     *
     *        - The second principle is to "random walk" java code. The pattern should be
     *          anchoring the code and the system tries code "inbetweening". Finally this
     *          is evaluated according to built in coding principles favouring generic,
     *          higher level and shorter constructions.
     *
     *
     *
     *      We do however see this is not really good enough. A third test case throws the system a bit off.
     */

    @Test
    public void getTagByNameTest3(){

        TagExtractor tag = new TagExtractor("This is a text without another #otherTag");
        assertThat("Tag name", tag.getTag(), is("#OTHERTAG"));
        assertThat(tag.isFound(), is(true));


    }


    /*************************************************************************
     *
     *          We run the 1000 Monkey Bot again and now we get more information out.
     *
     *
     *
     */



    class TagExtractor4{

        String s;

        public TagExtractor4(String s) {
            this.s = s;
        }

        public String getTag() {

            if(isFound())
                return (s.substring(s.indexOf("#") + 1).toUpperCase());
            return null;
        }

        public boolean isFound() {

            return s.indexOf("#") >= 0;
        }
    }

    /****************************************************************************'
     *
     *
     *          We can now give the 1000 Monkey Bot a directive {isFound:contains} to
     *          guide it in it's solution
     *
     */

    class TagExtractor5{

        String s;

        public TagExtractor5(String s) {
            this.s = s;
        }

        public String getTag() {

            if(isFound())
                return (s.substring(s.indexOf("#") + 1).toUpperCase());
            return null;
        }

        public boolean isFound() {

            return s.contains("#");
        }
    }

    /*****************************************************************************'
     *
     *          In the above case the 1000 Monkey Bot has to figure out the correct combination
     *          of substring, indexOf and toUpperCase to create the correct extraction.
     *
     *          This could be mapped to a pattern called something like "extract from point"
     *          that then can be applied.
     *
     *          The usage of patterns or JAVA constructions should be possible to add to the
     *          machine to cut the search tree and come to better solutions
     *
     *          e.g. sum(List<items>) can get the directive forEach to build a solution around the forEach loop)
     *
     *
     *          Here we can note that the generated solution still contains major issues. e.g.:
     *
     *           - We have not specified if the tag is one word or the rest of the system
     *
     *           This is solved by adding additional test cases
     */


}