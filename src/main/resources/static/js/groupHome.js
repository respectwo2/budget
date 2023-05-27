        // 검색된 그룹 보여주는 페이지로 이동하기
        function goToSearchPage(searchInput) {
            var searchTmp = document.getElementById(searchInput);
            var searchValue = searchTmp.value;

            location.href = "/group/search?q=" + searchValue;
        }

        // 그룹 만들기 페이지로 이동
        function goToGroupCreationPage() {
            location.href = "/group/create";
        }

        // 그룹의 피드로 이동
        function goToGroupFeed(gNo) {
            location.href = "/group/feed?groupNo=" + gNo;
        }

        // 태그로 그룹 조회해서 그룹 메인 보여주기
        function showGroupsByTag(tag) {
            location.href = "/group/list?tag=" + tag;
        }

        // 모달 열기
        function openModal(groupNo) {
            var modal = document.getElementById("groupModal");
            modal.style.display = "block";

            // 그룹 정보를 가져와서 모달에 표시하는 AJAX 요청
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var groupInfo = document.getElementById("groupInfo");
                    groupInfo.innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "/group/info?groupNo=" + groupNo, true);
            xhttp.send();
        }

        // 모달 닫기
        function closeModal() {
            var modal = document.getElementById("groupModal");
            modal.style.display = "none";
        }

        // 그룹 가입하기
        function groupJoin(gNo) {
            var groupNo = gNo;
            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/group/join";

            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "groupNo";
            input.value = groupNo;
            form.appendChild(input);

            document.body.appendChild(form);
            form.submit();
        }