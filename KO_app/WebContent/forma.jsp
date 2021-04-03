


<%@ page language="java" contentType="text/html; utf8_polish_ci "
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js1.js"></script>

</head>
<body>


<style>

body{
background-color:silver;
}

button{
background-color: lime;

}

ul{

}
 
li{
color: yellow;
}

h1{
text-align: center;


}

.center {
  text-align: center;
}

</style>



<h1>Menu</h1>


<form action="insert" method="get">
<ul>
<li>Pizza</li>
<ul>
<li><button type="button"  value="<c:out value='${c.pizza}' />" onclick="dodaj(20); ileRazy()">Margeritta 20zł </button> <p id="1" style="display: inline-block"> 0</p> </li>
<li><button type="button" value="<c:out value='${c.pizza}' />"  onclick="dodaj(22); ileRazy2()">Vegetariana 22zł </button>  <p id="2" style="display: inline-block"> 0</p> </li>
<li><button type="button" value="<c:out value='${c.pizza}' />"  onclick="dodaj(25); ileRazy3()">Tosca 25zł </button>  <p id="3" style="display: inline-block"> 0</p></li>
<li><button type="button"  value="<c:out value='${c.pizza}' />" onclick="dodaj(25); ileRazy4()">Venezia 25zł </button>  <p id="4" style="display: inline-block"> 0</p> </li>
</ul>
<li> Pizza dodatki - 2zł</li>
<ul>
<li><button type ="button" value="<c:out value='${c.dodatkiPizza}'/>"   onclick="dodaj(2);ileRazy5()">Podwójny ser</button> <p id="5" style="display: inline-block"> 0</p></li>
<li><button type ="button" value="<c:out value='${c.dodatkiPizza}'/>" onclick="dodaj(2);ileRazy6()">Salami</button> <p id="6" style="display: inline-block"> 0</p></li>
<li><button type ="button" value="<c:out value='${c.dodatkiPizza}'/>" onclick="dodaj(2);ileRazy7()">Szynka</button> <p id="7" style="display: inline-block"> 0</p></li>
<li><button type ="button" value="<c:out value='${c.dodatkiPizza}'/>" onclick="dodaj(2);ileRazy8()">Pieczarki</button> <p id="8" style="display: inline-block"> 0</p></li>
</ul>
<li>Dania główne</li>
<ul>
<li><button type="button" value="<c:out value='${c.danie}'/>"  onclick="dodaj(30);ileRazy9()"> Schabowy z frytkami-30zł </button> <p id="9" style="display: inline-block"> 0</p> </li>
<li><button type="button" value="<c:out value='${c.danie}'/>"  onclick="dodaj(30);ileRazy10()"> Schabowy z ryżem-30zł </button>  <p id="10" style="display: inline-block"> 0</p></li>
<li><button type="button"  value="<c:out value='${c.danie}'/>" onclick="dodaj(30);ileRazy11()"> Schabowy z ziemniakami-30zł </button>  <p id="11" style="display: inline-block"> 0</p></li>
<li><button type="button" value="<c:out value='${c.danie}'/>"  onclick="dodaj(28);ileRazy12()"> Ryba z frytkami-28zł </button> <p id="12" style="display: inline-block"> 0</p> </li>
<li><button type="button"  value="<c:out value='${c.danie}'/>" onclick="dodaj(27);ileRazy13()"> Placek po węgiersku-27zł </button>  <p id="13" style="display: inline-block"> 0</p> </li>
</ul>
<li>Dodatki do dań głównych</li>
<ul>
<li><button type="button"  value="<c:out value='${c.dodatkiDanie}'/>" onclick="dodaj(5);ileRazy14()"> Bar sałatkowy-5zł </button>  <p id="14" style="display: inline-block"> 0</p></li>
<li><button type="button" value="<c:out value='${c.dodatkiDanie}'/>"  onclick="dodaj(6);ileRazy15()"> Zestaw sosów - 6zł </button>  <p id="15" style="display: inline-block"> 0</p></li>
</ul>
<li>Zupy</li>
<ul>
<li><button type="button" value="<c:out value='${c.zupy}'/>"  onclick="dodaj(12);ileRazy16()"> Pomidorowa-12zł </button>  <p id="16" style="display: inline-block"> 0</p> </li>
<li><button type="button"  value="<c:out value='${c.zupy}'/>" onclick="dodaj(10);ileRazy17()"> Rosół-10zł </button>  <p id="17" style="display: inline-block"> 0</p></li>
</ul>
<li>Napoje-5zł</li>
<ul>
<li><button type="button"  value="<c:out value='${c.napoje}'/>"  onclick="dodaj(5);ileRazy18()"> Kawa </button> <p id="18" style="display: inline-block"> 0</p> </li>
<li><button type="button"  value="<c:out value='${c.napoje}'/>"  onclick="dodaj(5);ileRazy19()"> Herbata </button> <p id="19" style="display: inline-block"> 0</p> </li>
<li><button type="button"   value="<c:out value='${c.napoje}'/>"  onclick="dodaj(5);ileRazy20()"> Cola </button>  <p id="20" style="display: inline-block"> 0</p></li>
</ul>
</ul>
<bold>Uwagi:</bold> 
</br>
<textarea rows="5" cols="30" name="uwagi"  value="<c:out value='${c.uwagi}'/>"></textarea>
</br></br></br></br>

<p style="text-align:center"><b>Całkowity koszt zamówienia(PLN):</b></p><p id="koszt"  value="<c:out value='${c.koszt}'/>" style="text-align:center"> 0</p> 

</br</br>
<div class="center">


<a href="menu.jsp" >zapisz</a>
</div>
</form>


</body>
</html>