/**************************************************** 
Name (Full Name): Arjun Arunkumar Period 2
Name of the Lab/Assignment:  Polynomial lab
Purpose: create an interface and class to represent simple polynomials

Mistakes made:
- understanding what an interface was and how to implement the Polynomial object
- logic with printing out the polynomials through the toString() method
- not being able to efficiently come up with solutions for the plus() and differentiate() methods


How I feel about this programming experience: 
This program greatly strengthened my understanding of inheritance and interface concepts, along with
improved my java and refreshed me after a long summer since CSA. I struggled just a bit
in the lab because I was rusty on my array algo.


What I Learned: 
- using least classes/repetition as possible

		
****************************************************/

package Interface;
public class Pd1ArjunArunkumarPolynomialLab{
    public static void main(String[] args){
        double[] c = {1,0,3,4};
        double[] c1 = {-2,-5};

        Polynomial p1 = new ArrayBasedPolynomial(c);
        System.out.println("p1(x) = " + p1);

        Polynomial p2 = new ArrayBasedPolynomial(c1);
        System.out.println("p2(x) = " + p2);

        //Polynomial p3 = new ArrayBasedPolynomial(-4,-1);
        //System.out.println("p3(x) = " + p3);
    }
}


interface Polynomial{
    int getDegree(); //returns the degree of the polynomial
    double getCoefficient(int nth); //returns the coefficient for the given exponent
    double evaluate(double x); //evalute the polynomial at a given value of x
    Polynomial plus(Polynomial g); //Add two polynomials, and return their sum
    Polynomial minus(Polynomial g); //Subtract two polynomials, and return their difference
}



class ArrayBasedPolynomial implements Polynomial{
    private double[] coefficients;
    public ArrayBasedPolynomial(double[] coefficients){
        this.coefficients = coefficients;
    }

    public int getDegree(){
        return coefficients.length - 1;
    }

    public double getCoefficient(int nth){
        return coefficients[nth];
    }

    public double evaluate(double x){
        double evaluation = 0;
        for(int i = 0; i<coefficients.length; i++){
            evaluation += Math.pow(x,i) * coefficients[i];
        }
        return evaluation;
    }

    public Polynomial plus(Polynomial g){
        int maxDegree = Math.max(getDegree(), g.getDegree());
        double[] newCoefficients = new double[maxDegree+1];
        
        for(int i = 0; i<newCoefficients.length; i++){
            if(i<=getDegree() && i<= g.getDegree()){
                newCoefficients[i] = getCoefficient(i) + g.getCoefficient(i);
            }
            else if (i>=getDegree()){
                newCoefficients[i] = getCoefficient(i);
            }
            else if (i>=g.getDegree()){
                newCoefficients[i] = g.getCoefficient(i);
            }
        }
        return new ArrayBasedPolynomial(newCoefficients);
    }

    public Polynomial minus(Polynomial g){
        int maxDegree = Math.max(getDegree(), g.getDegree());
        double[] newCoefficients = new double[maxDegree + 1];

        for(int i = 0; i<newCoefficients.length; i++){
            if(i<=getDegree() && i<= g.getDegree()){
                newCoefficients[i] = getCoefficient(i) - g.getCoefficient(i);
            }
            else if(i>=getDegree()){
                newCoefficients[i] = getCoefficient(i);
            }
            else if(i>=g.getDegree()){
                newCoefficients[i] = -g.getCoefficient(i);
            }
        }
        return new ArrayBasedPolynomial(newCoefficients);
    }

    public String toString(){
        String polynomialOutput = "";
        for(int i = 0; i<coefficients.length; i++){
            polynomialOutput += coefficients[i];

            if(i==1){
                polynomialOutput += "x";
            }

            if(i>1){
                polynomialOutput += "x^" + i;
            }

            if(i<coefficients.length-1){
                polynomialOutput += " + ";
            }
        }
        return polynomialOutput;

    }
}

