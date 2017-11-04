
var selMovieNo = -1;  //선택한 영화 
var selMovieName = ''; //선택한 영화명
var selAdult_cnt = 0; //선택한 대인인원수
var selAdult_amt = 0; //선택한 시간표의 대인 일인 금액
var selChild_cnt = 0; //선택한 소인인원수
var selChild_amt = 0; //선택한 시간표의 소인 일인 금액
var selRoom_no = 0;   //선택한 영화관번호
var totalAmt = 0;
var selDate;          //선택한 상영일자 
var selSeat = new Array();      //선택된영화/날짜에 좌석 예약정보
var selSeatName = new Array();  //선택된영화/날짜에 좌석명칭
var selSeatSelected = new Array();  //현재 사용자가 선택한 좌석정보.값이 0이면 선택되지 않은것임
var thisToday = new Date();  // 현재일자
var timetable_detail_no = 0;  //선택한 정보
var rsvPlayDateAllList = new Array(); // 선택한 영화의 상영일자 list
var totalAmt = 0;



//Page Load 시에 현재 날짜를 기준으로 달력 생성한다.
window.onload = function() {
	
	//initialize Calendar & visibilities
	buildCalendarM(thisToday.getFullYear(), thisToday.getMonth()+1, thisToday.getDate(), rsvPlayDateAllList, selDate);
	setTotalResultDiv("init", "");

}


//영화선택시 : 영화별 상영일자를 가져온다 
function getMoviePlayDateList(movieNo, movieName) { 	
	selMovieNo = movieNo;
	selMovieName = movieName;
	selDate = null;
	 
	setPeopleDiv(0, 0, ''); //인원초기화
	setTotalResultDiv("movie", selMovieName);//계산결과초기화
	
	var param = "category=playdates&movie_no=" + selMovieNo;
	new ajax.xhr.Request("timeTableData.mt", param, loadDateList, 'GET');
}

function loadDateList(req){	
	if (req.readyState == 4) {
		if (req.status == 200) {
			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;	
			
			//상영일자 변수셋팅	
			rsvPlayDateAllList = new Array();
			if (code == 'success') {
				var resultList = eval( "(" + xmlDoc.getElementsByTagName('data').item(0).firstChild.nodeValue + ")" ); 
				for (var i = 0 ; i < resultList.length ; i++) {  
					rsvPlayDateAllList[i] = resultList[i].show_date;
				}			
			    
			} else if (code == 'error') {
				var message = xmlDoc.getElementsByTagName('message')
				                    .item(0).firstChild.nodeValue;
				alert("해당 영화는 현재 상영되고 있지 않습니다");
			}
			
			// 다시 달력 그린다
			buildCalendarM(thisToday.getFullYear(), thisToday.getMonth()+1, thisToday.getDate(), rsvPlayDateAllList, selDate);
		}
	}
}


//날짜선택시에 상영시간 목록을 보여준다
function getPlayDates(strPlayDate) {	 
	var ymd = strPlayDate.split("-")[0] + strPlayDate.split("-")[1] + strPlayDate.split("-")[2];
	selDate = ymd;
	var param = "category=list&movie_no=" + selMovieNo + "&playdate=" + ymd;
	new ajax.xhr.Request("timeTableData.mt", param, loadPlayList, 'GET');
	
	buildCalendarM(0, 0, 0, rsvPlayDateAllList, strPlayDate);
	setTotalResultDiv("date", "상영일자 : " + strPlayDate ); 
}


function loadPlayList(req){
	if (req.readyState == 4) {
		if (req.status == 200) {
			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;
			if (code == 'success') {
				var resultList = eval( "(" + xmlDoc.getElementsByTagName('data').item(0).firstChild.nodeValue + ")" );
				var listDiv = document.getElementById('rtlist');
				var html = "";  
				for (var i = 0 ; i < resultList.length ; i++) {  	 
					html = html + "<ul class=\'movie_choice\'><li><a href=\"javascript:setPeopleDiv(" + resultList[i].time_detail_no + "," +  resultList[i].room_no + ",'" + resultList[i].room_name + "/" + resultList[i].start_time + "');\">"
								+ resultList[i].room_name + "&nbsp;&nbsp;&nbsp;"
								+ resultList[i].start_time + "&nbsp;&nbsp;&nbsp;"
								+ (parseInt( resultList[i].total_seat ) - parseInt(resultList[i].reserved_seat) )+ "석" 
								+ "</a></li></ul>";
					
				} 
				listDiv.innerHTML = html ;
			} else if (code == 'error') {
				var message = xmlDoc.getElementsByTagName('message')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			}			
		}
	}	
}
 
//상영시간을 선택했을때  
function setPeopleDiv(no, room_no, msg) {	
	timetable_detail_no = no;
	selRoom_no = room_no;
	
	var element = document.getElementById('peopleSelect');
	
	if (msg.length > 0) {

		element.style.display='';
		
		var param = "time_detail_no=" + timetable_detail_no;
		new ajax.xhr.Request("timeDetailData.mt", param, setValues, 'GET'); 

		
		param = "category=seat&key1=" + room_no + "&key2=" + timetable_detail_no;
		new ajax.xhr.Request("reserveData.mt", param, drawSeat, 'GET');   
		
		cntDraw("adult");
		cntDraw("child");
		
	} else {
		element.style.display='none';
	}	
		
}

function drawSeat(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0).firstChild.nodeValue;
			
			if (code == 'success') {
				var result = eval( "(" + xmlDoc.getElementsByTagName('data').item(0).firstChild.nodeValue + ")" );
				
				//배열 재생성
				selSeatSelected = new Array();
				selSeat = new Array();
				selSeatName = new Array();
				
				for (var i=0; i<result.length; i++ ){
					selSeatSelected[i]=0;   //좌석 선택여부 초기화
					selSeat[i] = result[i].reserved;   //좌석 예약여부
					selSeatName[i] = result[i].seat_name; 
				}
				seatRedraw();
				
			} else if (code == 'error') {
				var message = xmlDoc.getElementsByTagName('message')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			}
		}	
	}
}

function seatRedraw(){
	var seatDiv = document.getElementById('selSeatCalc');
	var html = "<div class=\'tbl_type_04\'><table>"
	for( var i=0; i<selSeat.length; i++ ){
		if (i%10 == 0) { html = html + "<tr>"; }
		if (selSeatSelected[i]>0){
			html = html + "<td class=\"sel\"><a href=\"javascript:setSeat(" + i + ");\">" + selSeatName[i] + "</a></td>";
		} else if (selSeat[i]>0){
			html = html + "<td class=\"choice\">" + selSeatName[i] + "</td>";
		} else {
			html = html + "<td class=\"none\"><a href=\"javascript:setSeat(" + i + ");\">" + selSeatName[i] + "</a></td>";
		}			
		
		if (i%10 == 9) { html = html + "</tr>"; }
	}
	seatDiv.innerHTML = html + "</table></div>";	
}

function setValues(req){
	if (req.readyState == 4) {
		if (req.status == 200) {
			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0).firstChild.nodeValue;
			if (code == 'success') {
				var result = eval( "(" + xmlDoc.getElementsByTagName('data').item(0).firstChild.nodeValue + ")" );
				
				//alert("에러 발생:"+message);
				selAdult_amt = result[0].adult_amt ;
				selChild_amt = result[0].child_amt ;
				
				selAdult_cnt = 0;
				selChild_cnt = 0;
				
				setTotalResultDiv("time", "상영시작시간:" + result[0].start_time );
				
			} else if (code == 'error') {
				var message = xmlDoc.getElementsByTagName('message').item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			}			
		}
	}	
}

// 계산결과 보여주는 함수
function setTotalResultDiv(category, msg){	
	var movieDiv = document.getElementById('selMovie');	
	var dateDiv = document.getElementById('selDate');	
	var timeDiv = document.getElementById('selTime');	
	var adultDiv = document.getElementById('selAdult');	
	var childDiv = document.getElementById('selChild');	
	var calcDiv = document.getElementById('calcResult');
	var finalDiv = document.getElementById('finalSelection');
	var seatDiv = document.getElementById('seatSelection');	
	
	if (category=="init"){
		movieDiv.innerHTML = '';
		dateDiv.innerHTML = '';
		timeDiv.innerHTML = '';
		adultDiv.innerHTML = '';
		childDiv.innerHTML = '';
		calcDiv.innerHTML = '';		
		finalDiv.style.display = 'none';
		seatDiv.style.display = 'none';

		//좌석선택하는 Division invisible 및 초기화
		SeatSelection("init"); 
		
	} else if (category == "movie" ) {
		movieDiv.innerHTML = "<img src=\"/project/upload/movie/poster_" + selMovieNo + ".jpg\">" + "<span class=\'block mt10\'>" +selMovieName+ "</span>";
		dateDiv.innerHTML = '';
		timeDiv.innerHTML = '';
		adultDiv.innerHTML = ''; 
		childDiv.innerHTML = '';
		calcDiv.innerHTML = '';		
		finalDiv.style.display = 'none';	 
		seatDiv.style.display = 'none';		
		document.getElementById('rtlist').innerHTML = "";
		
	} else if (category == "date" ) { 
		dateDiv.innerHTML = msg;
		timeDiv.innerHTML = '';
		adultDiv.innerHTML = '';
		childDiv.innerHTML = '';
		calcDiv.innerHTML = '';		
		finalDiv.style.display = 'none';
		seatDiv.style.display = 'none';
		setPeopleDiv(0, 0, ''); //인원초기화 
		
	} else if (category == "time" ) { 
		timeDiv.innerHTML = msg;
		adultDiv.innerHTML = '';
		childDiv.innerHTML = '';
		calcDiv.innerHTML = '';		
		finalDiv.style.display = 'none';
		seatDiv.style.display = 'none';
		
	} else if (category == "cnt" ) {
		//alert("어른요금 : "+selAdult_amt + ", 소인요금 : " + selChild_amt);
		adultDiv.innerHTML = "대인 " + selAdult_cnt + "명 : " + (selAdult_amt*selAdult_cnt) + "원"; 
		childDiv.innerHTML = "소인 " + selChild_cnt + "명 : " + (selChild_amt*selChild_cnt) + "원"; 
		calcDiv.innerHTML = "총 " + ((selAdult_amt*selAdult_cnt)+(selChild_amt*selChild_cnt)) + "원";		
		finalDiv.style.display = 'none';
		seatDiv.style.display = '';
	}	
}

// 인원 선택시 변수 할당 및 결과값 계산
function setPeopleCount(gubun,cnt) { 		
	if ( gubun == 'A') {
		selAdult_cnt = cnt;
		cntDraw('adult');
	} else if (gubun == 'C') {
		selChild_cnt = cnt;
		cntDraw('child');
	} else {
		selAdult_cnt = 0 ;
		selChild_cnt = 0;
	}	 
	setTotalResultDiv("cnt", '');	
}

function cntDraw(category){	
	var selDiv = document.getElementById('cnt_' + category);
	var cnt = (category=='adult')? selAdult_cnt : selChild_cnt;
	var head = (category=='adult')? 'A' : 'C';
	var html = (category=='adult')? "<dt>대인</dt>" : "<dt>소인</dt>" ;
	html = html + "<dd><ul>";
	
	for(var i=0; i<6; i++){
		html = html + "<li class=\"";
		
		if (cnt==i) {
			html = html + "sel"; 
		} else { 
			html = html + "none" ; 
		}
		
		html = html + "\"><a href=\"javascript:setPeopleCount('" + head + "'," + i + ");\">" + i + "</a></li>";
	}
	selDiv.innerHTML = html + "</ul></dd>";	
}

function finalSelection() { 	
	var reserveCnt =  (selAdult_cnt + selChild_cnt);
	var seatCnt = seatCount();
	var selTera = (((selAdult_amt*selAdult_cnt)+(selChild_amt*selChild_cnt))*0.1); 
	if (seatCnt != reserveCnt ) {
		alert("예약인원(" + reserveCnt + ")과 좌석지정인원("+ seatCnt + ")이 맞지 않습니다");
		return;
	}
	
	//계산 결과 변수에 저장
	var calcResult=((selAdult_amt*selAdult_cnt)+(selChild_amt*selChild_cnt)); 
	
	document.final.time_detail_no.value = timetable_detail_no;  
	document.final.adult_cnt.value = selAdult_cnt; 
	document.final.child_cnt.value = selChild_cnt;
	document.final.torrentcal.value = selTera;
	document.final.total_amount.value = calcResult;
	
	
	var div = document.getElementById('selSeatCalc');
	var html = '';

	for (var i=0; i<selSeatSelected.length; i++){
		if ( selSeatSelected[i] > 0 ) {
			html = html + "<input type=hidden name=\"seat\" value=" + ( selSeatSelected[i] ) + ">"
		}
	}
	div.innerHTML = html;

	document.final.submit(); 
}

function SeatSelection(category){
	var seatDiv = document.getElementById('seat');	  //좌석선택
	var selDiv = document.getElementById('movieNcal');  //영화,달력
	var finalbuttonDiv = document.getElementById('finalSelection'); //예매완료버튼
	var seatbuttonDiv = document.getElementById('seatSelection');  //좌석선택버튼
	  
	if (category=="init") {   //초기화 : 영화,달력 보이기 / 좌석선택란,예매완료버튼,좌석선택버튼 숨기기
		selDiv.style.display = '';	
		seatDiv.style.display = 'none';	
		finalbuttonDiv.style.display = 'none';
		seatbuttonDiv.style.display = 'none';
	} else if (category == "back" ) {   
		selDiv.style.display = '';	
		seatDiv.style.display = 'none';	
		finalbuttonDiv.style.display = 'none';
		seatbuttonDiv.style.display = '';
	} else if (category == "seat" ) {  //좌석선택시 : 영화,달력 숨기기 / 좌석선택란,예매완료버튼 보이기 /  좌석선택버튼 숨기기 
		selDiv.style.display = 'none';	
		seatDiv.style.display = '';	
		finalbuttonDiv.style.display = '';
		seatbuttonDiv.style.display = 'none';	
	}
}

function setSeat(num){	
	var orgValue = selSeatSelected[num];
	var changeValue = (orgValue>0) ? 0: num+1;
	selSeatSelected[num] = changeValue;
	
	var cnt = seatCount();
	if ( cnt > selAdult_cnt + selChild_cnt) {
		alert("선택한 인원수를 초과하여 좌석을 지정할 수 없습니다\n" + cnt);
		selSeatSelected[num] = orgValue;
		return;
	} 
	
	seatRedraw();	
}

function seatCount() {
	var cnt=0;
	for (var i=0; i<selSeatSelected.length; i++) {
		if (selSeatSelected[i] > 0 ) { cnt ++; }
	}
	return cnt;
}
