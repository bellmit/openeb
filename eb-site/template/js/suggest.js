$("#keyword").autocomplete(domain+"/suggest", {
	delay : 10,
	minChars : 1,
	matchSubset : 1,
	matchContains : 1,
	cacheLength : 10,
	matchContains : true,
	scrollHeight : 100,
	width : 150,
	onItemSelect : selectItem,
	onFindValue : findValue,
	formatItem : formatItem,
	autoFill : false
});

function findValue(li) 
{

   $("#city").html("");
    if( li == null )
    {
      return  $("#city").html("未匹配值!");
    }
    if( !!li.extra )
    { 
       var sValue = li.extra[1];
        //文本域的值
       //  alert(sValue);
      // $("#hidCityValue").val(sValue)
      document.getElementById("<%=hidCityValue.ClientID %>").value=sValue;
    }
    else
    {
       var sValue = li.selectValue;
       
     // document.getElementById("<%=hidCityValue.ClientID %>").value=sValue;
    }
}
function selectItem(li) 
{
    findValue(li);
}
function formatItem(row) 
{
    return  row[0]+"&nbsp;&nbsp;&nbsp;"+row[1];
}
function lookupAjax()
{
    var oSuggest = $("#keyword")[0].autocompleter;

    oSuggest.findValue();

    return false;
}
function lookupLocal()
{    
      var oSuggest = $("#keyword")[0].autocompleter;    
      
      oSuggest.findValue();    
  
      return false;  
      
}  
