<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.event_main {
	margin: 0 auto;
	width: 1260px;
}

#eventBefore {
	
}

#eventAfter {
	display: none;
}

input#rating,
input#firstRating{
	font-size: 30px;
	border: none;
	width:25px;
}
</style>
<link rel="stylesheet" href="/resources/css/main.css" type="text/css" />
<script type="text/javascript" src="/resources/js/Winwheel.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenMax.min.js"></script>
</head>


<body>

   <jsp:include page="./layout/header.jsp"></jsp:include>
   <div class="event_main">

      <h1>포인트 향상 이벤트</h1>
      <h1>WW의 가입을 진심으로 축하합니다 !</h1>

      <table class="table table-striped">
         <tr>
            <th colspan="2">등급별 혜택</th>
         </tr>
         <tr>
            <td>A</td>
            <td>구매금액의 20% 포인트로 적립</td>
         </tr>
         <tr>
            <td>B</td>
            <td>구매금액의 15% 포인트로 적립</td>
         </tr>
         <tr>
            <td>C</td>
            <td>구매금액의 10% 포인트로 적립</td>
         </tr>
         <tr>
            <td>D(기본)</td>
            <td>구매금액의 5% 포인트로 적립</td>
         </tr>
      </table>
      <br>

      <c:if test="${ses.mem_rating ne 'D'}">
            ${ses.mem_id}님은 이미 이벤트에 참여하였습니다.!!!
            ${ses.mem_id}님 현재 <input id="rating" value="${ses.mem_rating }"> 등급
      </c:if>
		
      <c:if test="${ses.mem_rating eq 'D'}">   
        <div id="eventBefore"> ${ses.mem_id}님은 아직 <input id="firstRating" value="${ses.mem_rating }"> 등급입니다.!!!(등급변경가능)</div> 
        <div id="eventAfter"> ${ses.mem_id}님 <input id="rating" value="${ses.mem_rating }"> 등급입니다.!!! 축하합니다</div>     
        <div align="center">
            <table cellpadding="0" cellspacing="0" border="0">
               <tr>
                  <td>
                     <div class="power_controls">
                        <br /> <br />
                        <table class="power" cellpadding="10" cellspacing="0">
                           <tr>
                              <th align="center">Power</th>
                           </tr>
                           <tr>
                              <td width="78" align="center" id="pw3" onClick="powerSelected(3);">High</td>
                           </tr>
                           <tr>
                              <td align="center" id="pw2" onClick="powerSelected(2);">Med</td>
                           </tr>
                           <tr>
                              <td align="center" id="pw1" onClick="powerSelected(1);">Low</td>
                           </tr>
                        </table>
                        <br /> <img id="spin_button" src="/resources/img/spin_off.png" alt="Spin" onClick="startSpin();" />

                     </div>
                  </td>
                  <td width="438" height="582" class="the_wheel" align="center" valign="center">
                     <canvas id="canvas" width="434" height="434">
                            <p style="color: white" align="center">Sorry, your browser doesn't support canvas. Please try another.</p>
                        </canvas>
                  </td>
               </tr>
            </table>
         </div>
      </c:if>
      <script>
            // Create new wheel object specifying the parameters at creation time.
            let theWheel = new Winwheel({
                'numSegments'  : 8,     // Specify number of segments.
                'outerRadius'  : 212,   // Set outer radius so wheel fits inside the background.
                'textFontSize' : 28,    // Set font size as desired.
                'segments'     :        // Define segments including colour and text.
                [
                    {'fillStyle' : '#7286D3', 'text' : 'A'},
                     {'fillStyle' : '#8EA7E9', 'text' : 'B'},
                     {'fillStyle' : '#E5E0FF', 'text' : 'C'},
                     {'fillStyle' : '#FFF2F2', 'text' : 'D'},
                     {'fillStyle' : '#7286D3', 'text' : 'A'},
                     {'fillStyle' : '#8EA7E9', 'text' : 'B'},
                     {'fillStyle' : '#E5E0FF', 'text' : 'C'},
                     {'fillStyle' : '#FFF2F2', 'text' : 'D'}
                ],
                'animation' :           // Specify the animation to use.
                {
                    'type'     : 'spinToStop',
                    'duration' : 5,     // Duration in seconds.
                    'spins'    : 8,     // Number of complete spins.
                    'callbackFinished' : alertPrize
                }
            });

            // Vars used by the code in this page to do power controls.
            let wheelPower    = 0;
            let wheelSpinning = false;

            // -------------------------------------------------------
            // Function to handle the onClick on the power buttons.
            // -------------------------------------------------------
            function powerSelected(powerLevel)
            {
                // Ensure that power can't be changed while wheel is spinning.
                if (wheelSpinning == false) {
                    // Reset all to grey incase this is not the first time the user has selected the power.
                    document.getElementById('pw1').className = "";
                    document.getElementById('pw2').className = "";
                    document.getElementById('pw3').className = "";

                    // Now light up all cells below-and-including the one selected by changing the class.
                    if (powerLevel >= 1) {
                        document.getElementById('pw1').className = "pw1";
                    }

                    if (powerLevel >= 2) {
                        document.getElementById('pw2').className = "pw2";
                    }

                    if (powerLevel >= 3) {
                        document.getElementById('pw3').className = "pw3";
                    }

                    // Set wheelPower var used when spin button is clicked.
                    wheelPower = powerLevel;

                    // Light up the spin button by changing it's source image and adding a clickable class to it.
                    document.getElementById('spin_button').src = "/resources/img/spin_on.png";
                    document.getElementById('spin_button').className = "clickable";
                }
            }

            // -------------------------------------------------------
            // Click handler for spin button.
            // -------------------------------------------------------
            function startSpin()
            {
                // Ensure that spinning can't be clicked again while already running.
                if (wheelSpinning == false) {
                    // Based on the power level selected adjust the number of spins for the wheel, the more times is has
                    // to rotate with the duration of the animation the quicker the wheel spins.
                    if (wheelPower == 1) {
                        theWheel.animation.spins = 3;
                    } else if (wheelPower == 2) {
                        theWheel.animation.spins = 8;
                    } else if (wheelPower == 3) {
                        theWheel.animation.spins = 15;
                    }

                    // Disable the spin button so can't click again while wheel is spinning.
                    document.getElementById('spin_button').src       = "/resources/img/spin_off.png";
                    document.getElementById('spin_button').className = "";

                    // Begin the spin animation by calling startAnimation on the wheel object.
                    theWheel.startAnimation();

                    // Set to true so that power can't be changed and spin button re-enabled during
                    // the current animation. The user will have to reset before spinning again.
                    wheelSpinning = true;
                }
            }

            // -------------------------------------------------------
            // Function for reset button.
            // -------------------------------------------------------
            function resetWheel()
            {
                theWheel.stopAnimation(false);  // Stop the animation, false as param so does not call callback function.
                theWheel.rotationAngle = 0;     // Re-set the wheel angle to 0 degrees.
                theWheel.draw();                // Call draw to render changes to the wheel.

                document.getElementById('pw1').className = "";  // Remove all colours from the power level indicators.
                document.getElementById('pw2').className = "";
                document.getElementById('pw3').className = "";

                wheelSpinning = false;          // Reset to false to power buttons and spin can be clicked again.
            }

            // -------------------------------------------------------
            // Called when the spin animation has finished by the callback feature of the wheel because I specified callback in the parameters
            // note the indicated segment is passed in as a parmeter as 99% of the time you will want to know this to inform the user of their prize.
            // -------------------------------------------------------
            
              async function putGrade(memData){
            try {
                 const url='/event';
                 const config={
                     method : 'post',
                     headers : {
                         'content-type':'application/json; charset=utf-8'
                     },
                     body:JSON.stringify(memData)
                 };
                 const resp=await fetch(url,config);
                 const result=await resp.text();
                 return result; 
             } catch (error) {
                 console.log(error);
             }
         }
            
            function alertPrize(indicatedSegment)
            {
               const mnoVal = '<c:out value="${ses.mem_num}" />';
             console.log(mnoVal);
             
                  const mem_rating=indicatedSegment.text;
             console.log(mem_rating);
             let memData={
                mem_num:mnoVal,
                mem_rating:mem_rating
             };
             
              putGrade(memData).then(result=>{
                 if(result>0){
                      alert(mem_rating+"등급 혜택에 당첨되셨습니다 !!!");
                      document.getElementById('eventBefore').style.display="none";
                      document.getElementById('eventAfter').style.display="inline-block";
                      document.getElementById('rating').value = mem_rating;
                   
                 }
              })
             
            }
        </script>
        <br><br><br>
   </div>
   <jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>