import ch.decent.sdk.model.Account;
import ch.decent.sdk.model.NftData;
import ch.decent.sdk.model.NftModel;

import java.io.*;
import java.util.List;
import java.util.regex.PatternSyntaxException;


public class BlockgetStart {


    public static void main(String[] args) throws IOException {
       BlockgetAccount anAccount = new BlockgetAccount();
        Account myAcct = anAccount.getAccountByName("trevor3");
       System.out.println("hellow from blockget");
       System.out.println("registrar acct = " + myAcct.getRegistrar());

       String hashcode = "QmZfPNDiujH2KFuJhB47tAdup2ZY54611wiH6i15ZwTipa";
        BlockgetNftMgr bnm = new BlockgetNftMgr();
        String accountName = "trevor3";
        List<NftData<? extends NftModel>> result=bnm.ConfirmNFT(myAcct);
        NftModel c = result.get(0).getData();
        List<Object> d = c.values();
        String hashcodedata = (String) d.get(2);
        int g=1;
        //bnm.create("BGT"); // blockget token

       // bnm.issue("BGT", hashcode);


     //   System.out.println("name acct = " + myAcct.getName());
   //     String serverName = args[0];
   //     int port = Integer.parseInt(args[1]);
   //     BlockgetSocket bs = new BlockgetSocket();
   //     bs.addData(serverName, port);
     //   String fileName = "/home/trevor/decent/Master5/out/artifacts/Master5_main_jar/socketdata.txt";
     //   String fileName = "./socketdata.txt";

/*
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] inPorts;
        while((line = br.readLine()) != null){
            //process the line
            try {
                inPorts = line.split("\\s+");
                String ip=inPorts[0];
                String port=inPorts[1];
                String ip1=inPorts[2];
                String port1=inPorts[3];

                int portn = Integer.parseInt(port);
                int port1n = Integer.parseInt(port1);

                BlockgetSocket bs = new BlockgetSocket();
                String message = "filehash";
                bs.connect(ip, portn, ip1, port1n, message);


            } catch (PatternSyntaxException ex) {
                //
                System.out.println(ex);
            }

            System.out.println(line);
        }
*/

        int j=1;
    }

}

