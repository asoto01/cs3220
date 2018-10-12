package lab6;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MorseCode extends SimpleTagSupport {
	
	String input;
	
	
	public MorseCode() {
		input = "";
	}

	public void setInput(String input) {
		this.input = input.toLowerCase();
	}



	public static String morseCode( String s )
    {
			
        return 
        		s.replaceAll( "a", ".-" )
            .replace( "b", "-...")
            .replace( "c", "-.-." )
            .replace( "d", "-..")
            .replace( "e", "." )
            .replace( "f", "..-.")
            .replace( "g", "--." )
            .replace( "h", "...." )
            .replace( "i", ".." )
            .replace( "j", ".---" )
            .replace( "k", "-.-" )
            .replace( "l", ".-.." )
            .replace( "m", "--" )
            .replace( "n", "-." )
            .replace( "o", "..." )
            .replace( "p", ".--." )
            .replace( "q", "--.-" )
            .replace( "r", ".-." )
            .replace( "s", "---" )
            .replace( "t", "-" )
            .replace( "u", "..-" )
            .replace( "v", "...-" )
            .replace( "w", ".--" )
            .replace( "x", "-..-" )
            .replace( "y", "-.--" )
            .replace( "z", "--.." );
        		
    }
	
	public static String morseCode( char c )
    {	
		switch (c) {
		case 'a':
			return  ".-";
		case 'b':
			return "-...";
		case 'c':
			return "-.-.";
		case 'd':
			return  "-..";
		case 'e':
			return ".";
		case 'f':
			return "..-.";
		case 'g':
			return  "--.";
		case 'h':
			return "....";
		case 'i':
			return "..";
		case 'j':
			return  ".---";
		case 'k':
			return "-.-";
		case 'l':
			return ".-..";
		case 'm':
			return  "--";
		case 'n':
			return "-.";
		case 'o':
			return "...";
		case 'p':
			return  ".--.";
		case 'q':
			return "--.-";
		case 'r':
			return ".-.";
		case 's':
			return  "---";
		case 't':
			return "-";
		case 'u':
			return "..-";
		case 'v':
			return  "...-";
		case 'w':
			return ".--";
		case 'x':
			return "-..-";
		case 'y':
			return  "-.--";
		case 'z':
			return "--..";
		default:
			return "";
		}
        		
    }
	
	
	
    
    @Override
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        for (int i = 0; i < input.length(); i++) {
    			out.print(input.charAt(i) + " ");
    			out.print(morseCode(input.charAt(i)) + "<br>");
        }
    }

}
