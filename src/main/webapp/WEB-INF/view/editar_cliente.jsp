<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lumi.Model.Cliente" %>
<%
    @SuppressWarnings("unchecked")
    List<String> alergias= (List<String>) request.getAttribute("alergias-lista");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Editar Cliente</title>
    <link rel="icon" href="/src/main/webapp/assets/logo-infoone.ico">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="bg-gray-50 min-h-screen">
<header
        class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md">
    <div
            class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
        <h1 class="sm:ml-[-5%]"><img
                src="/src/main/webapp/assets/logo branca.png"
                width="80%" class="h-8 sm:h-auto"
                style="align-items: center;"></h1>

        <button id="menu-botao" class="sm:hidden p-2">
            <i data-feather="menu" class="w-6 h-6"></i>
        </button>
    </div>
</header>

<div class="flex pt-16 sm:pt-20 min-h-screen">

    <nav id="sidebar"
         class="fixed left-0 top-16 sm:top-20 h-full w-64 bg-white shadow-lg z-40 transform -translate-x-full sm:translate-x-0 transition-transform duration-300">

        <div class="flex flex-col h-full">

            <div class="p-4 border-b flex-shrink-0">
                <div class="text-center mb-2 mt-2">
                    <div
                            class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-2">
                        <i data-feather="user" class="text-[#7F3FBF]"></i>
                    </div>
                    <h2 class="font-bold text-lg">ADM</h2>
                <p class="text-sm text-gray-600"><%=session.getAttribute("adm")%></p>
                </div>
            </div>

            <div class="p-4 flex-grow overflow-y-auto">
              <ul class="space-y-2">
                  <li><a href="portal" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                          data-feather="home" class="mr-3"></i>Portal
                      ADM</a></li>
                  <li><a href="ingredientes" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                          data-feather="package"
                          class="mr-3"></i>Ingredientes</a></li>
                  <li><a href="alergias" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                          data-feather="alert-triangle"
                          class="mr-3"></i>Alergias</a></li>
                  <li><a href="clientes"  onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 bg-purple-100 rounded-lg text-[#333333] font-medium"><i
                          data-feather="users"
                          class="mr-3"></i>Cliente</a></li>
                  <li><a href="industrias" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                          data-feather="tool"
                          class="mr-3"></i>Indústria</a></li>
                  <li><a href="produtos" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                          data-feather="tag"
                          class="mr-3"></i>Produtos</a></li>
                  <li><a href="site" onclick="mostrarRedirecionando()"
                         class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-red-500"><i
                          data-feather="log-out"
                          class="mr-3"></i>Sair</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <div id="sidebar-overlay"
         class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

    <main class="sm:ml-64 flex-1 sm:p-8">
        <a href="produtos" onclick="mostrarRedirecionando()"><h1 class="text-left sm:mt-3"><i
                data-feather="arrow-left"></i></h1></a>
        <h1
                class="text-[2.25rem] font-bold text-[#333333] mb-8 text-center mt-[3%]"
                data-aos="fade-down">Alterar Cliente</h1>
        <div id="input"
             class="bg-white rounded-[15px] shadow-md p-8 max-w-lg mx-auto mt-[3%]"
             data-aos="fade-up" data-aos-delay="100">
            <form action="alterar-cliente" method="post">
                <div class="mb-6">
                    <label for="cpf"
                           class="block text-gray-700 text-sm font-medium mb-2">CPF:</label>
                    <input type="text" id="cpf" name="cpf"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("cpf")%>">

                    <label for="nome"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Nome:</label>
                    <input type="text" id="nome" name="nome"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("nome")%>">

                    <label for="sobrenome"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Sobrenome:</label>
                    <input type="text" id="sobrenome" name="sobrenome"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("sobrenome")%>">

                    <label for="peso"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Peso (kg):</label>
                    <input type="number" step="0.01" min="0" id="peso" name="peso"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("peso")%>">

                    <label for="altura"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Altura (m):</label>
                    <input type="number" step="0.01" min="0" id="altura" name="altura"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("altura")%>">

                    <label for="hta"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Pressão Alta:</label>
                    <select class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent" name="hta" id="hta">
                        <option disabled hidden selected value=""><%=(Boolean) request.getAttribute("pressao-alta") ? "Sim" : "Não"%></option>
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>

                    <label for="colesterol"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Colesterol Alto:</label>
                    <select class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent" name="colesterol" id="colesterol">
                        <option disabled hidden selected value=""><%=(Boolean) request.getAttribute("colesterol-alto") ? "Sim" : "Não"%></option>
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>

                    <label for="diabetes"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Diabetes:</label>
                    <select class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent" name="diabetes" id="diabetes">
                     <option selected hidden value="<%=request.getAttribute("diabetes")%>"><%=request.getAttribute("diabetes")%></option>
                        <option value="Tipo 1">Tipo 1</option>
                        <option value="Tipo 2">Tipo 2</option>
                        <option value="Gestacional">Gestacional</option>
                        <option value="Não possui">Não possui</option>
                    </select>
                    <label for="alergias-container"
                    class="block text-gray-700 text-sm font-medium mb-2 mt-2">Alergias:</label>
                    <div id="alergias-container" class="flex flex-col">
                     <%
                     List<String> alergiasDoCliente = (List<String>) request.getAttribute("alergiasLista");
                     List<String> todasAlergias = (List<String>) request.getAttribute("todas-alergias");
                     
                     if (alergiasDoCliente != null) {
                         for (int i = 0; i < alergiasDoCliente.size(); i++) {
                             String alergiaSelecionada = alergiasDoCliente.get(i);
                     %>
                     <div data-alergia-wrapper class="flex items-start space-x-2 mb-2" id="alergia-wrapper-<%=i+1%>">
                         <button type="button" class="text-red-500 hover:text-red-700 p-2 mt-2 btn-remover-alergia">
                             <i data-feather="minus" class="w-5 h-5"></i>
                         </button>
                         <select name="alergia-<%=i+1%>" class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">
                             <option value="" disabled hidden>Selecione uma alergia</option>
                             <% for (int j = 0; j < todasAlergias.size(); j++) { 
                                   String nomeAlergia = todasAlergias.get(j);
                            %>
                                 <option value="<%=nomeAlergia%>" <%=nomeAlergia.equals(alergiaSelecionada) ? "selected" : ""%>><%=nomeAlergia%></option>
                             <% } %>
                         </select>
                     </div>
                     <%
                         }
                     }
                     %>
                     </div>
             <button type="button" id="add-alergia"
                     class="flex items-center space-x-2 text-[#7F3FBF] hover:text-[#5B2E85] text-sm font-medium w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-3 py-2 rounded-[6px] ">
               <span>Adicionar alergia</span>
             </button>
                    <label for="data"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Data
                        de nascimento:</label>
                    <input type="date" id="data" name="data" value="<%=request.getAttribute("data-nascimento")%>"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">

                    <label for="e-mail"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">E-mail:</label>
                    <input type="email" id="e-mail" name="e-mail"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("email")%>" readonly>

                    <label for="telefone"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Telefone:</label>
                    <input type="text" id="telefone" name="telefone"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("telefone")%>">

                    <label for="senha"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Senha:</label>
                    <input type="text" id="senha" name="senha"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("senha")%>">

                    <label for="cidade"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Cidade:</label>
                    <input type="text" id="cidade" name="cidade"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("cidade")%>">

                    <label for="estado"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Estado:</label>
                    <select name="estado" id="estado"
                            class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">
                        <option selected hidden value="<%=request.getAttribute("uf")%>"><%=request.getAttribute("uf")%></option>
                        <option value="AC">AC</option>
                        <option value="AL">AL</option>
                        <option value="AP">AP</option>
                        <option value="AM">AM</option>
                        <option value="BA">BA</option>
                        <option value="CE">CE</option>
                        <option value="DF">DF</option>
                        <option value="ES">ES</option>
                        <option value="GO">GO</option>
                        <option value="MA">MA</option>
                        <option value="MT">MT</option>
                        <option value="MS">MS</option>
                        <option value="MG">MG</option>
                        <option value="PA">PA</option>
                        <option value="PB">PB</option>
                        <option value="PR">PR</option>
                        <option value="PE">PE</option>
                        <option value="PI">PI</option>
                        <option value="RJ">RJ</option>
                        <option value="RN">RN</option>
                        <option value="RS">RS</option>
                        <option value="RO">RO</option>
                        <option value="RR">RR</option>
                        <option value="SC">SC</option>
                        <option value="SP">SP</option>
                        <option value="SE">SE</option>
                        <option value="TO">TO</option>
                    </select>

                    <label for="cep"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">CEP:</label>
                    <input type="text" id="cep" name="cep"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           value="<%=request.getAttribute("cep")%>">
                </div>
                <div class="text-center">
                  <button type="submit" id="btn-adicionar"
                                class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-[#B4DF00] transition-colors">
                            <span id="btn-texto">Salvar</span>
                        </button>
                </div>
               
            </form>
        </div>
    </main>
</div>

<div id="tela-redirecionamento"
     class="fixed inset-0 bg-gray-50 z-[9999] flex-col items-center justify-center hidden">
    <div class="logo-container absolute top-6 left-6">
        <img id="logo" src="${pageContext.request.contextPath}/assets/Group 28.png" alt="Logo Lumi" class="w-16 h-16 object-contain">
    </div>

    <div class="carregando flex flex-col items-center justify-center h-full">
        <div class="loader">
            <div class="bolinhas"></div>
            <div class="bolinhas"></div>
            <div class="bolinhas"></div>
            <div class="bolinhas"></div>
        </div>
        <h1 class="text-2xl font-medium mt-8 text-gray-700">Redirecionando...</h1>
        <p class="text-gray-500 mt-2">Só um instante...</p>
    </div>
</div>

<script>
  AOS.init({ duration: 800, once: true });
  feather.replace();

  const alergiasOp = [];
  <% for (int i = 0; i < todasAlergias.size(); i++) { %>
  alergiasOp.push("<%=todasAlergias.get(i) %>");
  <% } %>
</script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<script src="${pageContext.request.contextPath}/js/alterarAlergia.js"></script>
<script src="${pageContext.request.contextPath}/js/mostrarTelas.js"></script>
</body>
</html>
            