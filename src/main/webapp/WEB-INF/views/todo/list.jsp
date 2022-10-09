<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
    <div class ="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                        <a class="nav-link" href="#">Features</a>
                        <a class="nav-link" href="#">Pricing</a>
                        <a class="nav-link disabled">Disabled</a>
                    </div>
                </div>
            </div>
        </nav>
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Search</h5>
                        <form action="/todo/list" method="get">
                            <input type="hidden" name="size" value = "${pageRequestDTO.size}">
                            <div class="mb-3">
                                <input type="checkbox" name="finished" ${pageRequestDTO.finished?"checked":""}> 완료여부
                            </div>
                            <div class="mb3">
                                <input type="checkbox" name="types" value="t" ${pageRequestDTO.checkType("t")?"checked":""}> 제목
                                <input type="checkbox" name="types" value="w" ${pageRequestDTO.checkType("w")?"checked":""}> 작성자
                                <input type="text" name="keyword" class="form-control">
                            </div>
                            <div class="input-group mb3 dueDateDiv">
                                <input type ="date" name="from" class="form-control">
                                <input type ="date" name="to" class="form-control">
                            </div>
                            <div class="input-grou mb-3">
                                <div class="float-end">
                                    <button class="btn btn-primary" type="submit">Search</button>
                                    <button class="btn btn-info clearBtn" type="reset">Clear</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row content">
        <div class="col">
        <div class="card">
            <div class="card-header">
                Featured
            </div>
            <div class="card-body">
              <h5 class="card-title">Special title treatment</h5>
                <table class="table">
                <thead>
              <tr>
                  <th scope="col">Tno</th>
                  <th scope="col">Title</th>
                  <th scope="col">Writer</th>
                  <th scope="col">DueDate</th>
                  <th scope="col">Finished</th>
              </tr>
              </thead>
            <tbody>
            <c:forEach items="${responseDTO.dtoList}" var ="dto">
                <tr>
                    <th scope="row"><c:out value="${dto.tno}"/> </th>
                    <th><a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none" data-tno="${dto.tno}">
                        <c:out value="${dto.title}"/> </a>
                    </th>
                    <th><c:out value="${dto.writer}"/> </th>
                    <th><c:out value="${dto.dueDate}"/> </th>
                    <th><c:out value="${dto.finished}"/> </th>
                </tr>
            </c:forEach>
            </tbody>
            </table>
                <div class ="float-end">
                    <ul class="pagination flex-wrap">
                        <c:if test="${responseDTO.prev}">
                            <li class="page-item">
                                <a class="page-link" data-num="${responseDTO.start -1}">Previous</a>
                            </li>
                        </c:if>
                        <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                            <li class="page-item ${responseDTO.page == num? "active" : ""}">
                                <a class="page-link" data-num="${num}">${num}</a></li>
                        </c:forEach>

                        <c:if test="${responseDTO.next}">
                            <li class="page-item">
                                <a class="page-link">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <script>
                    document.querySelector(".pagination").addEventListener("click", (e)=>{
                        e.preventDefault();
                        e.stopPropagation();

                        const target =e.target;

                        if (target.tagName !== 'A') {
                            return
                        }

                        const num = target.getAttribute("data-num");

                        self.location = `/todo/list?page=\${num}` //백틱(` `)을 이용해서 템플릿 처리

                    })
                    document.querySelector(".clearBtn").addEventListener("click", (e)=>{
                        e.preventDefault();
                        e.stopPropagation();

                        self.location="/todo/list"
                    },false)
                </script>
            </div>
        </div>
        </div>
        </div>
    </div>
    <div class="row fixed-bottom" style="z-index: -100">
        <footer class="py-1 my-1">
            <p class="text-center text-muted">Footer</p>
        </footer>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

</body>
</html>