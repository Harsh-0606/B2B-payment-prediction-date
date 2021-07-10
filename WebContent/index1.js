document.addEventListener("DOMContentLoaded", function(event) {
  document.getElementById("editbutton").disabled = true;
  document.getElementById("buttondelete").disabled = true;
});

var checkarray=[]

function tobechange(obj){
    var t=obj.parentNode.parentNode;
	var x = obj.id;

	if(obj.checked){
		if(checkarray.includes(x)){
			pass;
		}
		else{
			checkarray.push(x);
		}
		document.getElementById("buttonPlus").disabled=true;
	}
	else{
		let index = checkarray.indexOf(x);
		if (index > -1) 
		{
  			checkarray.splice(index, 1);
		}

		if(checkarray.length==0){
			document.getElementById("buttonPlus").disabled=false;
		}
	}

    t.style.background=(obj.checked) ?'#2A5368' : "" ; 

	if(checkarray.length==1)
		document.getElementById("editbutton").disabled=false;

	else
		document.getElementById("editbutton").disabled=true;

	if(checkarray.length>0)
		document.getElementById("buttondelete").disabled=false;

	else
		document.getElementById("buttondelete").disabled=true;	
}

function rowtoggle(source)
{
    toselect=document.getElementsByName("toggle");
	checkarray=[]
    for(let i=0; i <toselect.length;i++){
        toselect[i].checked=source.checked;
        tobechange(toselect[i])
    }

}

function showModal(){
  document.getElementById("myModal").style.display="block"; 
}

function closeModal(){
	document.getElementById("myModal").style.display="none"; 
}

function showModal1(){
  document.getElementById("myModal1").style.display="block"; 
}

function closeModal1(){
  document.getElementById("myModal1").style.display="none"; 
}

function showModal2(){
  document.getElementById("myModal2").style.display="block"; 
}

function closeModal2(){
  document.getElementById("myModal2").style.display="none"; 
}

const link="http://localhost:8080/H2HBABBA1036/table?page=";
var pageno=1;

function prevpage(){
	if(pageno>1){
		pageno--;
		getgridData();	
	}	
}

function nextpage(){
	pageno++;
	getgridData();
}

const getgridData=()=>{
	fetch(link+pageno)
		.then((res)=>{
			console.log(res);
			return res.json();
		})
		.then((data)=>{
			console.log(data);
			loadData(data);
		})
		.catch((e)=>{
			console.log("error : ",e);
		});
};
getgridData();

function loadData(invoicedata){
	const tableBody=document.getElementById('tableData');
	let dataHtml='';
	for (let invoice=0;invoice<invoicedata.length;invoice++){
		dataHtml+= `<tr class="tablerow">
		<td><input type="checkbox" id=${invoicedata[invoice].invoiceNO} name="toggle" onclick="tobechange(this);"/></td>
		<td>${invoicedata[invoice].customerName}</td>
		<td>${invoicedata[invoice].customerNO}</td>
		<td>${invoicedata[invoice].invoiceNO}</td>
		<td>${invoicedata[invoice].invoiceAmount}</td>
		<td>${invoicedata[invoice].dueDate}</td>
		<td>${invoicedata[invoice].PreddictedPaymentDate}</td>
		<td>${invoicedata[invoice].notes || "--" }</td>
		</tr>`;
	}
	console.log(dataHtml)
	tableBody.innerHTML=dataHtml;
}

function add(){
 	var customerName=document.getElementById("customerName").value;
	var customerNO=document.getElementById("customerNO").value;
	var  invoiceNO=document.getElementById("invoiceNO").value;
	var invoiceAmount=document.getElementById("invoiceAmount").value;
	var  dueDate=document.getElementById("dueDate").value;
	var addNotes=document.getElementById("addNotes").value;   
	fetch(`http://localhost:8080/H2HBABBA1036/InsertData?name_customer=${customerName}&cust_number=${customerNO}&doc_id=${invoiceNO}&total_open_amount=${invoiceAmount}&due_in_date=${dueDate}&notes=${addNotes}`,{
				method:"POST"
			});
}

function deleterec(){	
	var a=checkarray.toString();
	checkarray=[];
	fetch(`http://localhost:8080/H2HBABBA1036/DeleteData?doc_id=${a}`,{
		method:"POST"
	});
	closeModal2();
	location.reload();	
}

function edit(){
	var a=checkarray;
	checkarray=[]
	var note=document.getElementById("editnote").value;
	var incoiveamount=document.getElementById("invoiceupdate").value;
	fetch(`http://localhost:8080/H2HBABBA1036/EditInvoice?doc_id=${a}&total_open_amount=${incoiveamount}&notes=${note}`,{
		method:"POST"
	});
	getgridData();
	closeModal1();
}