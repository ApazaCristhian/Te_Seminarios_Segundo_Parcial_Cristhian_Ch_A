


<%
    String opcion = request.getParameter("opcion");
%>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("participante")?"active":"")%>" href="ParticipanteController">Participantes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("seminario")?"active":"")%>" href="SeminarioController">Seminarios</a>
    </li>
    
</ul>
