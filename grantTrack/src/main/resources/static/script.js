const BASE = "http://localhost:8080";

function show(msg){
    document.getElementById("msg").innerHTML = msg;
}

/* ---------------- FACULTY ---------------- */

function addFaculty(){

    fetch(BASE+"/faculty/register",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            name:fname.value,
            email:femail.value,
            department:fdept.value,
            designation:fdesig.value,
            password:fpass.value,
            role:frole.value
        })
    })
        .then(r=>r.json())
        .then(d=>show("Faculty Registered! ID : "+d.facultyId));

}

/* ---------------- STAGE ---------------- */

function addStage(){

    fetch(BASE+"/stage/add",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            stageName:sname.value,
            description:sdesc.value,
            orderNo:Number(sorder.value)
        })
    })
        .then(r=>r.json())
        .then(d=>show("Stage Added! ID : "+d.stageId));

}

/* ---------------- APPLICATION ---------------- */

function addApplication(){

    let fid=afaculty.value;
    let sid=astage.value;

    fetch(BASE+"/application/add/"+fid+"/"+sid,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            title:atitle.value,
            abstractText:aabstract.value,
            requestedAmount:Number(aamount.value),
            submittedDate:adate.value,
            status:"Submitted"
        })
    })
        .then(r=>r.json())
        .then(d=>show("Application Submitted! ID : "+d.applicationId));

}

/* ---------------- EXPENDITURE ---------------- */

function addExpense(){

    let aid=eapp.value;

    fetch(BASE+"/expenditure/add/"+aid,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            title:etitle.value,
            amount:Number(eamount.value),
            dateIncurred:edate.value,
            description:edesc.value,
            isApproved:eapprove.value==="true"
        })
    })
        .then(r=>r.json())
        .then(d=>show("Expense Saved! ID : "+d.expenditureId));

}