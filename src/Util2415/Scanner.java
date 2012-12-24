package Util2415;

/**
 * Homebrew Scanner class
 * 
 * @author SamCrane
 */

public class Scanner 
{
	
	public static final char END_CHARACTER = '#';
	private boolean endOfFile = false;
	InputStream input;
	
	public Scanner(String fileName)
	{
		try
		{
			InputConnection connection = (InputConnection) Connector.open("file:///" + fileName, Connector.READ);
			input = connection.openDataInputStream();
		}
		catch (Exception e)
		{
			System.out.println("File could not be opened. Most likely file " s + " was misplaced.");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	
	/* returns the next word in
	 * the stream of data. A quirk to this
	 * method is that if it finds the specified
	 * "halt" value, '#'
	 */
	public String next()
	{
		String s = "";
		char read = input.read();
		while (read == ' ')
		{
			read = input.read();
			if (read == END_CHARACTER)
			{
				endOfFile = true;
				return s; //if the final character is found, then return this.
			}
		}
		while (read != ' ')
		{
			s += read;
			read = input.read();
			if (read == END_CHARACTER)
				{
					endOfFile = true;
					return s; //if the final character is found, then return this.
				}
		}
		return s;
	}
	
	public boolean hasNext()
	{
		return !endOfFile; //they are logical opposites.
						   //the last piece of information will end
						   //end in '#', to notify end of file.
	}
	
	
	public void close()
	{
		input.close();
	}
}
