/**************************************************** 
Name (Full Name): Arjun Arunkumar Period 2
Name of the Lab/Assignment:  Polynomial lab
Purpose: create an interface and class to represent simple polynomials

Mistakes made:
- understanding what an interface was and how to implement the Polynomial object
- logic with printing out the polynomials through the toString() method
- not being able to efficiently think about how to create the other 2 constructors
- the concept for the integral method, and figuring out how to replace the constant value of C as I have never dealt with an integral before



How I feel about this programming experience: 
This program enhanced my data structure skills, and sharpened my brain to think of solutions to various implementations of concepts. Integrals and Derivates are concepts
I have never thought to explore before, as I have just started CALC BC. I learned about these concepts, and then applied what I learned to create solutions to different polynomials.
I really love math and this program allowed me to showcase mutliple solutions for implementations on math based topics.


What I Learned: 
- Interfaces
- Constructors with multiple methods and logic
- Using objects in various ways 

		
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

        Polynomial p3 = new ArrayBasedPolynomial(-4,1);
        System.out.println("p3(x) = " + p3);

        Polynomial p = p1.plus(p2).plus(p2);
        System.out.println("p(x) = " + p);

        Polynomial p4 = p.minus(p3);
        System.out.println("p4(x) = " + p4);

        Polynomial p5 = p4.derivative();
        System.out.println("p5(x) = " + p5);

        Polynomial p6 = p4.integral();
        System.out.println("p6(x) = " + p6);

        Polynomial clone = new ArrayBasedPolynomial(p5);
        System.out.println("clone(x) = " + clone);

        System.out.println("p5(0) = " + p5.evaluate(0));
        System.out.println("p5(1) = " + p5.evaluate(1));
    }
}


interface Polynomial{
    int getDegree(); //returns the degree of the polynomial
    double getCoefficient(int nth); //returns the coefficient for the given exponent
    double evaluate(double x); //evalute the polynomial at a given value of x
    Polynomial plus(Polynomial g); //Add two polynomials, and return their sum
    Polynomial minus(Polynomial g); //Subtract two polynomials, and return their difference
    Polynomial derivative();
    Polynomial integral();
}



class ArrayBasedPolynomial implements Polynomial{
    private double[] coefficients;
    public ArrayBasedPolynomial(double[] coefficients){
        this.coefficients = coefficients;
    }
    public ArrayBasedPolynomial(int coeff, int exp){
        coefficients = new double[exp + 1];
        coefficients[exp] = coeff;
    }

    //for the clone call this is an additional structure capable of cloning
    public ArrayBasedPolynomial(Polynomial polynomial){
        coefficients = new double[polynomial.getDegree()+1];
        for(int i = 0; i<=polynomial.getDegree(); i++){
            coefficients[i] = polynomial.getCoefficient(i);
        }
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
            else if (i<=getDegree()){
                newCoefficients[i] = getCoefficient(i);
            }
            else if (i<=g.getDegree()){
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
            else if(i<=getDegree()){
                newCoefficients[i] = getCoefficient(i);
            }
            else if(i<=g.getDegree()){
                newCoefficients[i] = -g.getCoefficient(i);
            }
        }
        return new ArrayBasedPolynomial(newCoefficients);
    }

    public Polynomial derivative(){
        double[] differentiatedPolynomial = new double[coefficients.length - 1];
        int j = 1;
        for(int i = 0; i<differentiatedPolynomial.length; i++){
            differentiatedPolynomial[i] = coefficients[j];
            j++;
        }
        for(int k = 0; k<differentiatedPolynomial.length; k++){
            differentiatedPolynomial[k] = differentiatedPolynomial[k] * (k+1);
        }
        return new ArrayBasedPolynomial(differentiatedPolynomial);

    }

    public Polynomial integral(){
        double[] integratedPolynomial = new double[coefficients.length+1];
        for(int i = integratedPolynomial.length-1; i>=0; i--){
            if(i==0){
                integratedPolynomial[i] = 0;
            }
            else{
                integratedPolynomial[i] = coefficients[i-1];
            }
        }
        for(int k = 0; k<integratedPolynomial.length; k++){
            if(k==0){
                integratedPolynomial[k] = 0;
            }
            else{
                integratedPolynomial[k] = integratedPolynomial[k]/k;
            }
        }

        return new ArrayBasedPolynomial(integratedPolynomial);
    }
    

    public String toString(){
        String polynomialOutput = "";
        for(int i = coefficients.length - 1; i >= 0; i--){
            if(coefficients[i] != 0){
                if(coefficients[i] > 0 && polynomialOutput.length() > 0){
                    polynomialOutput += " + ";
                }
                if(coefficients[i] < 0){
                    polynomialOutput += " - ";
                }
                if(i == 0){
                    polynomialOutput += Math.abs(coefficients[i]);
                }
                else if(i == 1){
                    polynomialOutput += Math.abs(coefficients[i]) + "x^1";
                }
                else{
                    polynomialOutput += Math.abs(coefficients[i]) + "x^" + i;
                }
            }
        }
        return polynomialOutput;
    }

}

/* OUTPUT : 
p1(x) = 4.0x^3 + 3.0x^2 + 1.0
p2(x) =  - 5.0x^1 - 2.0
p3(x) =  - 4.0x^1
p(x) = 4.0x^3 + 3.0x^2 - 10.0x^1 - 3.0
p4(x) = 4.0x^3 + 3.0x^2 - 6.0x^1 - 3.0
p5(x) = 12.0x^2 + 6.0x^1 - 6.0
p6(x) = 1.0x^4 + 1.0x^3 - 3.0x^2 - 3.0x^1
clone(x) = 12.0x^2 + 6.0x^1 - 6.0
p5(0) = -6.0
p5(1) = 12.0
*/