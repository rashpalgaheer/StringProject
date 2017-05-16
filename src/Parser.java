

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Parser 
{
	private static final String FILENAME = "//Users//rashpalsingh//Desktop//test.txt";
	static Vector<Metadata> vector =  new Vector<>();
		public static void getStrings()
		{
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;
			String readLine;
			String seenDigit = "";
			char[] checkChar = null;
			char[] checkChar2 = null;
			
			
			
//			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) 
			{
				Metadata m = new Metadata();
				System.out.println(sCurrentLine);
				char[] ch = sCurrentLine.toCharArray();
				
				int i = 0;
				while (i < ch.length)
				{
					char c = ch[i];
			        if (c >= '0' && c <= '9')
			        {
			            seenDigit += c;
			            i++;
			            continue;
			        }
			        break;
			        
				}
				checkChar = new char[ch.length - i];
				int j = i;
				int x = 0;
				while(j < ch.length)
				{
					checkChar[x] = ch[j]; 
					j++;
					x++;
				}

				m.setLen(Integer.parseInt(seenDigit));
				m.setS(checkChar);
				vector.add(m);
				seenDigit = "";
			}
			
//			System.out.println(seenDigit);
//			System.out.println(checkChar);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
