package Main.Interfaces;

import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.*;

import java.util.*;

@Ignore
public class myReporter implements IReporter {


    //@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        System.out.println("*****TEST REPORT*****");

        for (XmlSuite xmlSuite: xmlSuites){

            System.out.println("Suite Name: " + xmlSuite.getName() );

            for (XmlTest xmlTest: xmlSuite.getTests()) {

                System.out.println("Test Name: " + xmlTest.getName());

                for (XmlClass xmlClass: xmlTest.getClasses()) {
                    System.out.println("Class Name: " + xmlClass.getName());

                    xmlClass.getIncludedMethods().add(new XmlInclude("test1"));


                    for (XmlInclude xmlInclude: xmlClass.getIncludedMethods()) {
                        System.out.println(xmlInclude.getName());// + ": " + xmlinclude.getDescription());
                    }
                }
            }
        }
    }
}
