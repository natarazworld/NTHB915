<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:choose>
  <c:when test="${!empty listEmps && !empty pagesCount}">
    <h1 style="color:red;text-align:center"> The Report is  </h1>
      <table align="center" bgcolor="cyan">
          <tr>
             <th>ENO</th> <th>ENAME</th> <th>EADD</th> <th>ESALARY</th> 
           </tr>
           <c:forEach var="emp"  items="${listEmps}">
             <tr>
                <td>${emp.eno}  </td>
                 <td>${emp.ename}  </td>
                 <td>${emp.eadd}  </td>
                 <td>${emp.salary}  </td>                             
             </tr>
           </c:forEach>
      </table>
       <br>
       <p style="text-align:center">
        <c:forEach  var="i"  begin="1"  end="${pagesCount}">
             [ <a href="controller?pageNo=${i}"> ${i} </a> ]  &nbsp;&nbsp;&nbsp;
        </c:forEach>
      </p>
  </c:when>
   <c:otherwise>
       <h1 style="color:red;text-align:center">Records not found </h1>
   </c:otherwise>
</c:choose>


<br><br>
<a  href="input.html">home</a>

