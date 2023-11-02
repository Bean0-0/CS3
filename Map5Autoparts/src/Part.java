public class Part implements Comparable<Part>
{
	private String make, model, rest;
	private int year;


	public Part(String line)
	{
		String[] list = line.split("\\d+");
		String[] numbers = line.split("[a-zA-Z ]+");


		rest = list[0].trim() + " " + numbers[1].trim();


		String[] make_model = list[1].split(" ");


		make = make_model[1].trim();
		model = make_model[2].trim();


		year = Integer.parseInt(numbers[2]);
	}


	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{
		String a = this.toString();
		String b = rhs.toString();


		return a.compareTo(b);


	}


	public String toString()
	{
		return make + " " + model + " " + year + " " + rest;
	}
}
