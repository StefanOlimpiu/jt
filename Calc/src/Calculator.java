import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Calculator {

	public static void main(String[] args) {
		//Operation add = new Add();
		
		//BinaryOperator<Double> add = (p1,p2) -> p1+p2;
		Operation add1 = new Add();
		BinaryOperator<Double> add = add1::calc;
		//Operation add = (p1,p2) -> p1+p2;
		Operation div = (p1,p2) -> {
			if (p2==0) throw new IllegalArgumentException();
			return (p1/p2);
		};
		Calculator calculator = new Calculator();
		calculator.print(add, 2D,3D);
		calculator.print(div, 2D,3D);
		
		
		BinaryOperator<Double> adder =  (p1, p2) -> p1+p2;
		Consumer<BinaryOperator<Double>> printer = p -> System.out.println(p.apply(2D,3D));
		printer.accept(adder);
		
	}
	 
	public void print(Operation operation, Double a, Double b){
		System.out.println(operation.calc(a, b));
	}
	
	public void print(BinaryOperator operation, Double a, Double b){
		System.out.println(operation.apply(a, b));
	}

}
