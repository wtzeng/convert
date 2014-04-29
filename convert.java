/* August 30, 2002
 * convert.java
 * Instructions: Open a telnet connection to mud.stick.org port: 9000.
 * Login and enable color text by typing, "highlight". Use "java <text>"
 * to create text with encoded color scheme. Paste encoded text from
 * the clipboard into the telnet application by rigth clicking or
 * typing ctrl-v.
 */

import java.awt.*;
import java.awt.datatransfer.*;

public class convert implements ClipboardOwner
{
  public static void main(String[] args)
  {
    convert color = new convert(args);
  }

  public convert(String[] args)
  {
    /* the sequence of 36 colors with corresponding bold colors */
    String[] strColors = new String[72];

    strColors[0] = "\\te_   ";
    strColors[1] = "\\no_fro";
    strColors[2] = "\\ro_des";
    strColors[3] = "\\ch_quo";
    strColors[4] = "\\ch_quo";
    strColors[5] = "\\ch_inf";
    strColors[6] = "\\li_ite";
    strColors[7] = "\\fi_spe";
    strColors[8] = "\\pr_   ";
    strColors[9] = "\\no_sub";
    strColors[10] = "\\ro_exi";
    strColors[11] = "\\ch_gos";
    strColors[12] = "\\ch_mus";
    strColors[13] = "\\ch_mus";
    strColors[14] = "\\fi_yhi";
    strColors[15] = "\\he_top";
    strColors[16] = "\\no_num";
    strColors[17] = "\\ro_thi";
    strColors[18] = "\\ch_que";
    strColors[19] = "\\ch_poe";
    strColors[20] = "\\ch_cla";
    strColors[21] = "\\fi_thi";
    strColors[22] = "\\he_tex";
    strColors[23] = "\\no_tex";
    strColors[24] = "\\ro_ent";
    strColors[25] = "\\ch_ans";
    strColors[26] = "\\ch_mud";
    strColors[27] = "\\li_num";
    strColors[28] = "\\fi_dea";
    strColors[29] = "\\no_to ";
    strColors[30] = "\\ro_tit";
    strColors[31] = "\\ch_jok";
    strColors[32] = "\\ch_jok";
    strColors[33] = "\\ch_auc";
    strColors[34] = "\\li_pos";
    strColors[35] = "\\fi_sta";
    strColors[36] = "\\te!   ";
    strColors[37] = "\\no!fro";
    strColors[38] = "\\ro!des";
    strColors[39] = "\\ch!quo";
    strColors[40] = "\\ch!quo";
    strColors[41] = "\\ch!inf";
    strColors[42] = "\\li!ite";
    strColors[43] = "\\fi!spe";
    strColors[44] = "\\pr!   ";
    strColors[45] = "\\no!sub";
    strColors[46] = "\\ro!exi";
    strColors[47] = "\\ch!gos";
    strColors[48] = "\\ch!mus";
    strColors[49] = "\\ch!mus";
    strColors[50] = "\\fi!yhi";
    strColors[51] = "\\he!top";
    strColors[52] = "\\no!num";
    strColors[53] = "\\ro!thi";
    strColors[54] = "\\ch!que";
    strColors[55] = "\\ch!poe";
    strColors[56] = "\\ch!cla";
    strColors[57] = "\\fi!thi";
    strColors[58] = "\\he!tex";
    strColors[59] = "\\no!tex";
    strColors[60] = "\\ro!ent";
    strColors[61] = "\\ch!ans";
    strColors[62] = "\\ch!mud";
    strColors[63] = "\\li!num";
    strColors[64] = "\\fi!dea";
    strColors[65] = "\\no!to ";
    strColors[66] = "\\ro!tit";
    strColors[67] = "\\ch!jok";
    strColors[68] = "\\ch!jok";
    strColors[69] = "\\ch!auc";
    strColors[70] = "\\li!pos";
    strColors[71] = "\\fi!sta";

    StringBuffer buffer = new StringBuffer();
    int intCounter = 0;

    /* obtain the system clipboard */
    Toolkit kit = Toolkit.getDefaultToolkit();
    Clipboard copy = kit.getSystemClipboard();

    /* take in arguments from the command line and add them
       to a buffer for processing */

    if (args.length == 0)
    {
      System.out.println("Convert - A Java color conversion utility for Stick in the MUD.");
      System.out.println("Usage: Step 1. java convert <text message>");
      System.out.println("       Step 2. Paste selection into your mud client.");
    }
    else
    {
      for (int i = 0; i < args.length; i++)
      {
        if (i == args.length - 1)
        {
          buffer.append(args[i]);
        }
        else
        {
          buffer.append(args[i]);
          buffer.append(" ");
        }
      }

      int total = buffer.length();

      /* create a string copy to utilize the toUpperCase() method */
      String strRaw = buffer.toString();

      /* randomly capitalize letters in the string */
      String strTemp = "";
      for (int i = 0; i < total; i++)
      {
        if(Math.random() * 10 > 5)
        {
          strTemp = strRaw.substring(i).toUpperCase();
          buffer.setCharAt(i, strTemp.charAt(0));
        }
      }

      /* randomly colorize letters in the string */
      int intValue = 0;
      for (int i = 0; i < total; i++)
      {
        intValue = (int)(Math.random() * strColors.length);
        buffer.insert(intCounter, strColors[intValue]);
        intCounter = intCounter + 8;
      }

      /* return the string's color to normal */
      buffer.append("\\\\");

      /* add the string to the clipboard buffer */
      StringSelection selection = new StringSelection(buffer.toString());
      copy.setContents(selection, convert.this);
    }
  }

  public void lostOwnership(Clipboard parClipboard, Transferable parTransferable)
  {
    /* required to implement the interface */
  }
}
