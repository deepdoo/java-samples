package .util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtilities {

    @SuppressWarnings("unchecked")
    public static void showParameters(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            out.print("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<I>No Value</I>");
                else
                    out.println(paramValue);
            } else {
                out.println("<UL>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<LI>" + paramValues[i]);
                }
                out.println("</UL>");
            }
        }
    }

/**
	 * Replaces characters that have special HTML meanings with their
	 * corresponding HTML character entities. Specifically, given a string, this
	 * method replaces all occurrences of {@literal
	 *  '<' with '&lt;', all occurrences of '>' with
	 *  '&gt;', and (to handle cases that occur inside attribute
	 *  values), all occurrences of double quotes with
	 *  '&quot;' and all occurrences of '&' with '&amp;'.
	 *  Without such filtering, an arbitrary string
	 *  could not safely be inserted in a Web page.
	 *  }
	 */

    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return (input);
        }
        StringBuilder filtered = new StringBuilder(input.length());
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
            case '<':
                filtered.append("&lt;");
                break;
            case '>':
                filtered.append("&gt;");
                break;
            case '"':
                filtered.append("&quot;");
                break;
            case '&':
                filtered.append("&amp;");
                break;
            default:
                filtered.append(c);
            }
        }
        return (filtered.toString());
    }

    private static boolean hasSpecialChars(String input) {
        boolean flag = false;
        if ((input != null) && (input.length() > 0)) {
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                switch (c) {
                case '<':
                    flag = true;
                    break;
                case '>':
                    flag = true;
                    break;
                case '"':
                    flag = true;
                    break;
                case '&':
                    flag = true;
                    break;
                }
            }
        }
        return (flag);
    }

    public static String makeList(String listItems) {
        StringTokenizer tokenizer = new StringTokenizer(listItems, ", ");
        String list = "<UL>\n";
        while (tokenizer.hasMoreTokens()) {
            list = list + "  <LI>" + tokenizer.nextToken() + "\n";
        }
        list = list + "</UL>";
        return (list);
    }

    private ServletUtilities() {
    } // Uninstantiatable class
}
