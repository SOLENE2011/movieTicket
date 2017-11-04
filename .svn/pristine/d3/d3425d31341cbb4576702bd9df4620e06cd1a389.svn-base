var thisToday = new Date();  
var rsvSelDate;

//이전달의 달력 생성
function gotoPrevMonth(PREVDATE, datelist) {
    var sYear = "";
    var sMonth = "";
    var sDay = "";
    try {
        if (PREVDATE.length == 0) {
            sYear = thisToday.getFullYear();
            sMonth = thisToday.getMonth() - 1;
            sDay = thisToday.getDate();
        }
        else {
            sYear = parseInt(PREVDATE.split("-")[0], 10);
            sMonth = parseInt(PREVDATE.split("-")[1], 10);
            sDay = parseInt(PREVDATE.split("-")[2], 10);
        }
        buildCalendarM(sYear, sMonth, sDay, datelist);
    } catch (err) { }
}

// 다음달 달력생성
function gotoNextMonth(NEXTDATE, datelist) {
    var sYear = "";
    var sMonth = "";
    var sDay = "";
    try {
        if (NEXTDATE.length == 0) {
            sYear = thisToday.getFullYear();
            sMonth = thisToday.getMonth() - 1;
            sDay = thisToday.getDate();
        }
        else {
            sYear = parseInt(NEXTDATE.split("-")[0], 10);
            sMonth = parseInt(NEXTDATE.split("-")[1], 10);
            sDay = parseInt(NEXTDATE.split("-")[2], 10);
        }
        buildCalendarM(sYear, sMonth, sDay, datelist);
    } catch (err) { }
}


//달력 생성 Main 부분
function buildCalendarM(strYear, strMonth, strDay, PlayList, strSelDate) {

 var intMonthsDay = new Array(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
 var blankNextMonthDay = 1;
 var strCalendarHTML = "";
 var intThisYear = new Number();
 var intPrevYear = new Number();
 var intThisMonth = new Number(); 
 var intThisDay = new Number();
 var firstDay = new Number();
 var tempPlayDate = ""; 
 var tempMonth = "";
 var tempDay = "";  
 var PREVDATE = "", NEXTDATE  = ""; 
 
 rsvSelDate  = strSelDate;
 	
 try {

	 if (strSelDate != null && strSelDate.length == 10 ) {
	     intThisYear = parseInt(strSelDate.split("-")[0], 10);
	     intThisMonth = parseInt(strSelDate.split("-")[1], 10);
	     intThisDay = parseInt(strSelDate.split("-")[2], 10);
	 } else {	 
	     intThisYear = parseInt(strYear, 10);
	     intThisMonth = parseInt(strMonth, 10);
	     intThisDay = parseInt(strDay, 10);  
	 }

     if (intThisYear == 0)
         intThisYear = thisToday.getFullYear();
     if (intThisMonth == 0)
         intThisMonth = parseInt(thisToday.getMonth(), 10) + 1;
     if (intThisDay == 0)
         intThisDay = thisToday.getDate();

     switch (intThisMonth) {
         case 1:
             intNextYear = intThisYear;
             intPrevYear = intThisYear - 1;
             intPrevMonth = 12;
             intNextMonth = 2;
             break;
         case 12:
             intNextYear = intThisYear + 1;
             intPrevYear = intThisYear;
             intPrevMonth = 11;
             intNextMonth = 1;
             break;
         default:
             intPrevYear = intThisYear;
             intPrevMonth = parseInt(intThisMonth, 10) - 1;
             intNextYear = intThisYear;
             intNextMonth = parseInt(intThisMonth, 10) + 1; ;
             break;
     }
     
     PREVDATE = intPrevYear + "-" + intPrevMonth + "-1";
     NEXTDATE = intNextYear + "-" + intNextMonth + "-1";
     firstDay = new Date(intThisYear, intThisMonth - 1, 1);
     firstWeekDay = firstDay.getDay();
     firstWeekDay2 = intMonthsDay[intThisMonth - 1];

     if(((intThisYear%4==0)&&(intThisYear %100 !=0))||intThisYear % 400 ==0 ){
         intMonthsDay[2] = 29;
     }

     firstPrintDay = 1;
     intLastDay = intMonthsDay[intThisMonth];

     //Calendar Header
     strCalendarHTML = "<div class='tbl_type_03'><table>" ;
     strCalendarHTML += "<thead><tr><th scope='col'>월</th>";
     strCalendarHTML += "<th scope='col'>화</th>" ;
     strCalendarHTML += "<th scope='col'>수</th>" ;
     strCalendarHTML += "<th scope='col'>목</th>" ;
     strCalendarHTML += "<th scope='col'>금</th>" ;
     strCalendarHTML += "<th scope='col'>토</th>" ;
     strCalendarHTML += "<th scope='col'>일</th>" ;
     strCalendarHTML += "	</tr></thead><tbody>";
     
     //Calendar Days
     for (var loopWeek = 1; loopWeek <= 6; loopWeek++) {
         strCalendarHTML += "<tr>";
         for (var loopDay = 1; loopDay <= 7; loopDay++) {
         
             if (firstWeekDay > 0) {
            	//이전달표시
                 strCalendarHTML += "<td class=\"none\"><a href='#none'>" + (parseInt(firstWeekDay2) - firstWeekDay + 1)+"</a>";        
                 firstWeekDay--;
             }
             else {
                 if (firstPrintDay > intLastDay) {
                	//다음달 표시
                     strCalendarHTML += "<td class=\"none\"><a href='#none'>" + blankNextMonthDay +"</a>";                                
                     blankNextMonthDay++;
                 }
                 else {
                     if (intThisMonth < 10) {
                         tempMonth = "0" + intThisMonth;
                     }
                     else {
                         tempMonth = intThisMonth;
                     }
                     if (firstPrintDay < 10) {
                         tempDay = "0" + firstPrintDay;
                     }
                     else {
                         tempDay = firstPrintDay;
                     }
                     //tempPlayDate = intThisYear + "-" + tempMonth + "-" + tempDay;
                     tempPlayDate = intThisYear + "-" + tempMonth + "-" + tempDay;

                     retClass = checkPlayDateM(tempPlayDate, PlayList);
                    
                     if (retClass.length == 0) {
                         strCalendarHTML += "<td  class=\"none\"><a href=\"#none\" >" +firstPrintDay + "</a></td>";
                     }
                     else {
                         strCalendarHTML += "<td class="+ retClass +"><a href=\"javascript:getPlayDates('" + tempPlayDate + "');\" >" + firstPrintDay + "</a></td>"; 
                     }
                 }
                 firstPrintDay++;
             }
             strCalendarHTML += "</td>";
         }
         strCalendarHTML += "</tr>";
         if (firstPrintDay > intLastDay)
             break;
     }
     strCalendarHTML +="</tbody></table></div>";
     
     if (intThisMonth < 10) {
         displayMovieItemList = "0" + intThisMonth;
     }
     else {
         displayMovieItemList = intThisMonth;
     }
     document.getElementById('movieCalendar').innerHTML = strCalendarHTML;
     if(strMonth.length==1) {
     	strMonth = "0"+ strMonth ;
     } 
     
     var calDateHtml = "<span><a href=\"javascript:gotoPrevMonth('" + PREVDATE + "');\">이전달</a></span>";
     calDateHtml += "<span class=\"mon\"> " + intThisYear+"."+ intThisMonth + " </span>"; 
     calDateHtml += "<span><a href=\"javascript:gotoNextMonth('" + NEXTDATE + "');\">다음달</a></span>";
 
     tmpDiv = document.getElementById('calendar_date').innerHTML = calDateHtml; 


 } catch (err) { }
}

//달력에서 사용함 : 해당 일자에 상영정보가 있는지 확인한다 (상영정보는 rsvPlayDateAllList 에 들어 있음 )
function checkPlayDateM(strThisDay, rsvPlayDateAllList) {

 var strClass = "";
 try {
	 if ( rsvSelDate == strThisDay ) {
		 strClass = "sel";
	 } else {
	     for (var i = 0; i < rsvPlayDateAllList.length; i++) {
	     	
	         if (rsvPlayDateAllList[i] == strThisDay) {
	         	strClass = "sun";
	         }
	     }
	 }
 } catch (err) { }
 finally { }
 return strClass;
}