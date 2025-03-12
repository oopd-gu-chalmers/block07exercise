package polygons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSubtyping {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Graphics g = frame.getGraphics();
        testSubtyping(g);
    }

    public static void testSubtyping(Graphics g) {
        // TODO: Step 0a: Look at these six variables, and their
        //  static (declared) types. We're going to test them
        //  in various ways, so remember what the static types are.
        Polygon[]      polyArray = new Polygon[10];
        Triangle[]     triArray  = new Triangle[10];

        List<Polygon>  polyList  = new ArrayList<>();
        List<Triangle> triList   = new ArrayList<>();

        List<? extends Polygon> coPolyList     = new ArrayList<>();
        List<? super Polygon>   contraPolyList = new ArrayList<>();

        // TODO: Step 0b: Look at these four variables, and their
        //  static (declared) types AND dynamic types. We're going
        //  to use them to test the collections above.
        Object   obj = new Object();
        Polygon  pol = new Triangle(1, 1);
        Triangle tri = new Triangle(2, 2);
        Square   squ = new Square(3, 3);


        // TODO: Step 1a: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
//        polyArray[0] = pol;                   // OK
//        polyArray[1] = tri;                   // OK
//        triArray[0]  = pol;                   // static error
//        triArray[1]  = tri;                   // OK
//        triArray[2]  = (Triangle) pol;        // OK, dynamic type of pol is Triangle
//
//        polyList.add(pol);                    // OK
//        polyList.add(tri);                    // OK
//        triList.add(pol);                     // static error
//        triList.add(tri);                     // OK
//        triList.add((Triangle) pol);          // OK
//        triList.add((Triangle) obj);          // runtime error, cannot cast Object to Triangle
//
//        coPolyList.add(pol);                  // static error, only null can be safely added
//        coPolyList.add(tri);                  // static error
//        coPolyList.add(obj);                  // static error
//        contraPolyList.add(pol);              // OK
//        contraPolyList.add(tri);              // OK
//        contraPolyList.add(obj);              // static error

        // TODO: Step 1b: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        obj = polyList.get(0);              // OK
//        pol = polyList.get(0);              // OK
//        tri = polyList.get(0);              // static error
//        tri = (Triangle) polyList.get(0);   // OK if element has dynamic type Triangle
//        pol = triList.get(0);               // OK
//        tri = triList.get(0);               // OK
//
//        pol = coPolyList.get(0);            // OK if element ha dynamic type which extends Polygon
//        tri = coPolyList.get(0);            // static error
//        pol = contraPolyList.get(0);        // static error
//        tri = contraPolyList.get(0);        // static error
//        obj = contraPolyList.get(0);        // OK since everything extends Object


        // TODO: Step 1c: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        triArray  = (Triangle[]) polyArray;         // runtime error, cannot cast narrower
//        polyArray = triArray;                       // OK
//        triArray  = polyArray;                      // static error
//        triArray  = (Triangle[]) polyArray;         // OK if polyArray has dynamic type Triangle[]
//
//        triList  = polyList;                        // static error
//        polyList = triList;                         // static error
//        polyList = (List<Triangle>) triList;        // static error
//
//        coPolyList = polyList;                      // OK
//        coPolyList = triList;                       // OK
//        polyList   = coPolyList;                    // static error
//        triList    = coPolyList;                    // static error
//
//        contraPolyList = polyList;                  // OK
//        contraPolyList = triList;                   // static error
//        polyList       = contraPolyList;            // static error
//        triList        = contraPolyList;            // static error
//
//        coPolyList     = contraPolyList;            // static error
//        contraPolyList = coPolyList;                // static error
//
//        for (Polygon p : coPolyList)
//            contraPolyList.add(p);                  // OK


        // TODO: Step 2a: Predict what the results of these lines will be.
        //    Will they work, or will they lead to a static type error?
        //    Then, uncomment them add check. Were your answers correct?
//        paintAll(g, polyList);          // OK
//        paintAll(g, triList);           // static error
        // TODO: Step 2b: There's no reason why 'paintAll' shouldn't
        //    work for both lists. Can you change the parameter type
        //    for 'polygons' in the declaration of 'paintAll' below,
        //    so that it works for both cases above?


        // TODO: Step 3a: Predict what the results of these lines will be.
        //    Will they work, or will they lead to a static type error?
        //    Then, uncomment them add check. Were your answers correct?
//        addAll(polyList, polyList);       // OK
//        addAll(triList, polyList);        // static error
//        addAll(polyList, triList);        // static error, impossible to fix
//        addAll(triList, triList);         // static error
        // TODO: Step 3b: Can you change the parameter types for 'from'
        //    and 'to' in the declaration of 'addAll' below, to make it
        //    work for three out of four cases above?
        //    Why can you not make it work for the fourth?
        //    (Hint: it's for a good reason.)


        final Polygon polygon = pol;
        // TODO: Step 4: Look up the types of the three following methods
        //    from Java's standard libraries (hover over the method names
        //    in IntelliJ, don't mind the warnings).
        //    Can you explain why they have the declared types they do?
        polyList.addAll(triList);                       // What is the parameter type of addAll? Collection<? extends E> : added elements must be subtypes
        boolean b = polyList.containsAll(triList);      // What is the parameter type of containsAll? Collection<?> : dynamic types could be anything
        polyList.removeIf(p -> p.equals(polygon));      // What is the parameter type of removeIf? Predicate<? super E> : filter can run on any supertype


        // TODO: Step 5: Predict what the results of these lines will be.
        //    Will they work? Will they lead to a static type error?
        //    Will they cause a dynamic (runtime) error (i.e. an exception)?
        //    If they cause an error, why?
        //    Then, uncomment them and run. Were your answers correct?
//        polyArray = triArray;           // OK, Polygon[] is superclass of Triangle[]
//        polyArray[0] = squ;             // runtime error if dynamic type is Triangle[], OK if Polygon[]
//        tri = triArray[0];              // OK, compatible runtime type Triangle
//
//        polyList = triList;             // static error, List<Polygon> not a superclass of List<Triangle>
//        polyList.add(0, squ);           // OK, Polygon is superclass of Square
//        tri = triList.get(0);           // OK, compatible runtime type Triangle

    }

    // TODO: Step 2b: Change the parameter type of 'polygons' to
    //    the broadest (most general) type possible with respect
    //    to how it is used in the method body.
    public static void paintAll(Graphics g, List<? extends Polygon> polygons) {
        for (Polygon p : polygons)
            p.paint(g);
    }

    // TODO: Step 2d: Change the parameter types of 'from' and 'to' to
    //    the broadest (most general) types possible, given how they
    //    are used respectively in the method body.
    public static <P extends Polygon, R extends P> void addAll(List<R> from, List<P> to) {
        for (P p : from)
            to.add(p);
    }

}
