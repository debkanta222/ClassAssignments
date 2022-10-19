package Assignment;
class CountryNotValidExecption extends Exception{
	CountryNotValidExecption(String str){
		super(str);
	}
}
class EmployeeNameInvalidException extends Exception{
	EmployeeNameInvalidException(String str){
		super(str);
	}
}
class TaxNotEligibleException extends Exception{
	TaxNotEligibleException(String str){
		super(str);
	}
}
 class TaxCalculator {
static double taxAmount;
	public static double calculateTax(String empName,boolean isIndian,double empSal) throws CountryNotValidExecption,EmployeeNameInvalidException,TaxNotEligibleException  {
		
		if(isIndian==false) {
		throw new CountryNotValidExecption("The employee should be an Indian citizen for calculating tax.");
			}
				if(empName==null) {
			throw new EmployeeNameInvalidException("The employee name cannot be empty");
		}
			if(empSal>100000&&isIndian==true) {
			taxAmount=empSal*8/100;
		}
		else if(empSal>=50000||empSal<=100000&&isIndian==true) {
			taxAmount=empSal*6/100;
		}
		else if(empSal>=30000||empSal<=50000&&isIndian==true) {
			taxAmount=empSal*5/100;
		}
		else if(empSal>=10000||empSal<=30000&&isIndian==true) {
			taxAmount=empSal*4/100;
		}
		else {
			throw new TaxNotEligibleException("The employee does not need to pay tax");
		}

		return taxAmount;
	}
	public class CalculatorSimulator{
		public static void main(String[] args) throws CountryNotValidExecption,EmployeeNameInvalidException,TaxNotEligibleException {
			 {
				try {
				System.out.println(calculateTax("ron",false,10000));
			}
			catch(CountryNotValidExecption e1) {	
			
				System.out.println(e1.getMessage());
			}
			try {
				System.out.println(calculateTax(null,true,30000));
			}
			catch(EmployeeNameInvalidException e2) {
				//e.printStackTrace();
				System.out.println(e2.getMessage());
			}
				try {
					System.out.print("tax amount is : ");
					System.out.println(calculateTax("jack",true,55000));
				}
				catch(TaxNotEligibleException e3) {
					
					//System.out.println(e3.getMessage());
					e3.printStackTrace();
			}
				try {
					System.out.println( "the amount is :" +calculateTax("tim",true,1000));
					System.out.print("the employee does not need to pay tax. ");
				}
				catch(TaxNotEligibleException e4) {
					//e.printStackTrace();
					
			}
				
	}
	}}}
