//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public abstract class CSVReader 
//{
//	
//	private static HashMap<String, Double> resources = new HashMap<String, Double>();
//	
//	public static double getValue(String s)
//	{
//		return resources.get(s);
//	}
//	
//	public static void getFromFile(String s)
//	{
//		try
//		{
//			Scanner sc = new Scanner(new File(s));
//			
//			while (sc.hasNext())
//			{
//				resources.put(sc.next(), sc.nextDouble());
//			}
//			sc.close();
//		}
//		catch (IOException ioe)
//		{
//			ioe.printStackTrace();
//			System.exit(-1);
//		}
//	}
//	
//	public static void main(String[] args)
//	{
//		CSVReader.getFromFile("CSVFile.txt");
//		System.out.print(CSVReader.resources.toString());
//	}
//}
