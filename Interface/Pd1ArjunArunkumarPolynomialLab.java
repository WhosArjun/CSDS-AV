package Interface;

interface Polynomial{
  int degree();
  double coefficient(int exponent);
  double evaluate(double x);
  Polynomial sum(Polynomial x);
  Polynomial differentiate(Polynomial x);
}


class ArrayBasedPolynomial implements Polynomial{
    private double[] coefficients;
    public ArrayBasedPolynomial(double[] coefficients){
        this.coefficients = coefficients;
    }

    public int degree(){
        return coefficients.length - 1;
    }

    public double coefficient(int exponent){
        return coefficients[exponent-1];
    }

    public double evaluate(double x){
        double sum = 0;
        for(int i = 0; i<coefficients.length; i++){
            sum+= Math.pow(x, i) * coefficients[i];
        }
        return sum;
    }

    public Polynomial sum(Polynomial x){
        double[] newCoefficients;
        int maxDegree = 0;
        if(x.degree()>coefficients.length){
            maxDegree = x.degree();
        }
        else{
            maxDegree = coefficients.length;
        }
        newCoefficients = new double[maxDegree];

        for(int i = 0; i<maxDegree; i++){
            if(x.degree()<i && coefficients.length<i){
                newCoefficients[i] = x.coefficient(i) + coefficients[i];
            }
            else if(x.degree()>i && coefficients.length<i){
                newCoefficients[i] = coefficients[i];
            }
            else if(x.degree()<i && coefficients.length>i){
                newCoefficients[i] = x.coefficient(i);
            }
        }

        double[] finalCoefficients = new double[newCoefficients.length];
        for(int i = 0; i<finalCoefficients.length; i++){
            finalCoefficients[i] = newCoefficients[i];
        }
        return new ArrayBasedPolynomial(finalCoefficients);
    }

    public Polynomial differentiate(Polynomial x){
        double[] newCoefficients;
        int maxDegree = 0;
        if(x.degree()>coefficients.length){
            maxDegree = x.degree();
        }
        else{
            maxDegree = coefficients.length;
        }
        newCoefficients = new double[maxDegree];

        for(int i = 0; i<maxDegree; i++){
            if(x.degree()<i && coefficients.length<i){
                newCoefficients[i] = x.coefficient(i) - coefficients[i];
            }
            else if(x.degree()>i && coefficients.length<i){
                newCoefficients[i] = coefficients[i];
            }
            else if(x.degree()<i && coefficients.length>i){
                newCoefficients[i] = x.degree();
            }
        }

        double[] finalCoefficients = new double[newCoefficients.length];
        for(int i = 0; i<finalCoefficients.length; i++){
            finalCoefficients[i] =  newCoefficients[i];
        }

        return new ArrayBasedPolynomial(finalCoefficients);
    }

    public String toSring(){
        String polynomialMessage = "";
        for(int i = 0; i<degree() + 2; i++){
            if(coefficients[i] != 0){
                if(i != 0){
                    polynomialMessage += coefficients[i] + "x^" + (degree() + 1 - i) + "+";
                }
                if(i == 0){
                    polynomialMessage += coefficients[i]; 
                }
            }
        }
        return polynomialMessage;
    }


    public class Pd1ArjunArunkumarPolynomialLab{
        public static void main(String[] args){
            double[] c = {1,0,-3,4};
            double[] c1 = {-2,-5};

            Polynomial p1 = new ArrayBasedPolynomial(c);
            System.out.println("p1(x) = " + p1);

            Polynomial p2 = new ArrayBasedPolynomial(c1);
            System.out.println("p2(x) = " + p2);
        }
    }


}