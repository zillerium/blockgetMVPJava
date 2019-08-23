function addFile1() {
    url  = document.getElementById("fileurl").value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://ec2-54-173-250-212.compute-1.amazonaws.com:3000/addfileb", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("url=" + url );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "ok") {
		documet.getElementById("message").innerHTML = "Error in system";

        } else {
           filename = data.hash[0].hash;
		fname = "https://gateway.btfs.trongrid.io/btfs/"+ filename;
           document.getElementById("addedfile").innerHTML=fname;
           document.getElementById("addedfile").href=fname;
        }
      }
    };
}

function addFile() {
    url  = document.getElementById("fileurl").value;
    account  = document.getElementById("account").value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://54.92.219.108:9090/addBitData", true);
xhttp.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    xhttp.send(JSON.stringify({ "url": url, "account": account }));

    xhttp.onreadystatechange = function(){
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);


           filename = data.cid;
                fname = "https://gateway.btfssoter.io/btfs/"+ filename;
           document.getElementById("addedfile").innerHTML=fname;
           document.getElementById("addedfile").href=fname;
      }
    };
}

function readFile() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET",  "http://54.92.219.108:9090/pledges", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "ok") {
                document.getElementById("message").innerHTML = "Error in system";

        } else {
           document.getElementById("addedfile").innerHTML="done";
           document.getElementById("addedfile").href="done";
        }
      }
    };
}


function addAccount() {
    account  = document.getElementById("newaccount").value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://blockget.store:3000/createAccount", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("account=" + account );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "Correct") {
                document.getElementById("message").innerHTML = "Error in adding account";

        } else {
                 document.getElementById("message").innerHTML = "Account added";
        }
      }
    };
}

function issueNFT() {
    nftsymbol  = document.getElementById("addnftinstancesymbol").value;
    hash  = document.getElementById("hash").value;
	account = "trevor3";
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://blockget.store:3000/issueNFT", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("to=" + account + "&nftSymbol="+nftsymbol + "&hash="+hash );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "Correct") {
                document.getElementById("message").innerHTML = "Error";

        } else {
                 document.getElementById("message").innerHTML = "NFT Instance Add";
        }
      }
    };
}


function checkAccount() {
    account  = document.getElementById("checkaccount").value;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://blockget.store:3000/accountExists", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("account=" + account );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "Correct") {
                document.getElementById("message").innerHTML = "Error";

        } else {
		exists = data.exists;
		if (exists) {
                 document.getElementById("message").innerHTML = "exists";
		} else {
		document.getElementById("message").innerHTML = "Does not exist";
		}
        }
      }
    };
}

function addNFTtype() {
    nftsymbol  = document.getElementById("nftsymbol").value;
    maxsupply  = document.getElementById("maxsupply").value;
    accountName = "trevor3"; // default for testing
    desc = "nft for " + nftsymbol;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://blockget.store:3000/mintNFT", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("accountName=" + accountName+ "&symbol="+ nftsymbol+ "&description="+desc+ "&max_supply="+maxsupply );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
	      
		            document.getElementById("message").innerHTML = "NFT Issued " + nftsymbol + " supply " + maxsupply;
        
      }
    };
}

function checkNFTtype() {
    nftsymbol  = document.getElementById("checknftsymbol").value;
    nftarray=[]; 
    nftarray.push(nftsymbol);
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST",  "http://blockget.store:3000/getALLNFTsBySymbol", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	 xhttp.send("symbol="+ nftsymbol );
    xhttp.onreadystatechange = function(){
      var messageDiv = document.getElementById("message");
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        if (data.message != "Correct") {
                document.getElementById("message").innerHTML = "Error";

        } else
              {
		       document.getElementById("nftissuestatus").innerHTML = "Tokens Issued " + data.data[0].currentSupply;
console.log("data = " + data);
        }
      }
    };
}


