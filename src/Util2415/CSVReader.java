package Util2415;

import java.util.Hashtable;

/**
 * Code to read from CSV file and reupdate constants
 * 
 * @author SamCrane
 */

public abstract class CSVReader 
{
	
	private static Hashtable<String, Double> resources = new Hashtable<String, Double>();
	
	public static double getValue(String s)
	{
		return resources.get(s);
	}
	
	public void getFromFile(String s)
	{
		try
		{
			Scanner sc = new Scanner(s);
			
			while (sc.hasNext())
			{
				resources.put(sc.next(), Double.parseDouble(sc.next()) );
			}
			sc.close();
		}
		catch (Exception ioe)
		{
			ioe.printStackTrace();
			System.exit(-1);
		}
	}
}
