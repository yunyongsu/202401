<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 : 로그인</title>
</head>
<body>
<div id="wrap" class="wrap">
    <div class="u_skip"><a href="https://www.naver.com">본문 바로가기</a></div>
    <header class="header" role="banner">
        <div class="header_inner">
            <a href="https://www.naver.com" class="logo">
                <h1 class="blind">NAVER</h1>
            </a>
            <div class="lang" id="show_locale_switch">
                <select id="locale_switch" name="locale_switch" title="언어선택" class="sel">
                    <option value="ko_KR">한국어</option>
                    <option value="en_US">English</option>
                    <option value="zh-Hans_CN">中文(简体)</option>
                    <option value="zh-Hant_TW">中文(台灣)</option>
                </select>
            </div>
        </div>
    </header>

    <div id="container" class="container">
        <!-- content -->
        <div class="content">
            <div class="login_wrap">
                <ul class="menu_wrap" role="tablist">
                    <li class="menu_item" role="presentation">
                        <!--[주] 탭메뉴 활성화시(=선택시) "on"을 추가해주세요. 접근성: aria-selected는 탭 선택시 true, 미선택시 false로 적용-->
                        <!--[주:접근성] 탭메뉴의 id 값과 탭내용의 aria-controls를 연결하고 있습니다. -->
                        <a href="#none" id="loinid" class="menu_id on" role="tab" aria-selected="true">
                            <span class="menu_text"><span class="text">ID 로그인</span></span>
                        </a>
                    </li>
                    <li class="menu_item" role="presentation">
                        <a href="#none" id="ones" class="menu_ones" role="tab" aria-selected="false">
                            <span class="menu_text"><span class="text">일회용 번호</span></span>
                        </a>
                    </li>
                    <li class="menu_item" role="presentation">
                        <a href="#none" id="qrcode" class="menu_qr" role="tab" aria-selected="false">
                            <span class="menu_text"><span class="text">QR코드</span></span>
                        </a>
                        <!--넛지배너-->
                        <div class="nudge_banner" id="nudge_tooltip">
                            <span class="nudge_text">PC방 등 공용PC라면 QR코드 로그인이 더 안전해요.</span>
                            <button type="button" id="nudge_close" class="nudge_close"><span class="icon_nudge_close"></span></button>
                        </div>
                    </li>
                </ul>
                <form id="frmNIDLogin" name="frmNIDLogin" target="_top" autocomplete="off" action="https://nid.naver.com/nidlogin.login" method="POST">
                    <input type="hidden" id="localechange" name="localechange" value="">
                    <input type="hidden" name="dynamicKey" id="dynamicKey" value="p3_M9WVSsPcaEPR16xVngpoMh-BBAotnWJtKoejkTVaWIayV_Q9yPASUEqFpcdvjqB0duQPIDDi_oGCqQkzhBt5p1QCF5ra8sbk4p5GT3r4">
                    <input type="hidden" name="encpw" id="encpw" value="">
<input type="hidden" name="enctp" id="enctp" value="1">
<input type="hidden" name="svctype" id="svctype" value="1">
<input type="hidden" name="smart_LEVEL" id="smart_LEVEL" value="1">
<input type="hidden" name="bvsd" id="bvsd" value="">
<input type="hidden" name="encnm" id="encnm" value="">
<input type="hidden" name="locale" id="locale" value="ko_KR">
<input type="hidden" name="url" id="url" value="https://section.blog.naver.com/BlogHome.naver?directoryNo=0&amp;currentPage=1&amp;groupId=0">


                    <ul class="panel_wrap">
                        <li class="panel_item" style="display: block;">
                            <div class="panel_inner" role="tabpanel" aria-controls="loinid">
                                <div class="id_pw_wrap">
                                    <div class="input_row" id="id_line">
                                        <div class="icon_cell" id="id_cell">
                                            <span class="icon_id">
                                                <span class="blind">아이디</span>
                                            </span>
                                        </div>
                                        <input type="text" id="id" name="id" placeholder="아이디" title="아이디" class="input_text" maxlength="41" value="">
                                        <span role="button" class="btn_delete" id="id_clear" style="display: none;">
                                            <span class="icon_delete">
												<span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                    <div class="input_row" id="pw_line">
                                        <div class="icon_cell" id="pw_cell">
                                            <span class="icon_pw">
                                                <span class="blind">비밀번호</span>
                                            </span>
                                        </div>
                                        <input type="password" id="pw" name="pw" placeholder="비밀번호" title="비밀번호" class="input_text" maxlength="16">
                                        <span role="button" class="btn_delete" id="pw_clear" style="display: none;">
                                            <span class="icon_delete">
                                                <span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                                <div class="login_keep_wrap" id="login_keep_wrap">
                                    <div class="keep_check">
                                        <input type="checkbox" id="keep" name="nvlong" class="input_keep" value="off">
                                        <label for="keep" class="keep_text">로그인 상태 유지</label>
                                    </div>
                                    <div class="ip_check">
                                        <a href="/login/ext/help_ip3.html" target="_blank" id="ipguide" title="IP보안"><span class="ip_text">IP보안</span></a>
                                        <span class="switch">
                                            <input type="checkbox" id="switch" class="switch_checkbox" value="off">
                                            <label for="switch" class="switch_btn">
                                                <span class="blind" id="switch_blind">on</span>
                                            </label>
                                        </span>
                                    </div>
                                </div>

                                <div class="login_error_wrap" id="err_capslock" style="display: none;">
                                    <div class="error_message">
                                        <strong>CapsLock</strong>이 켜져 있습니다.
                                    </div>
                                </div>

                                <div class="login_error_wrap" id="err_empty_id" style="display: none;">
                                    <div class="error_message">
                                        <strong>아이디</strong>를 입력해 주세요.
                                    </div>
                                </div>

                                <div class="login_error_wrap" id="err_empty_pw" style="display: none;">
                                    <div class="error_message">
                                        <strong>비밀번호</strong>를 입력해 주세요.
                                    </div>
                                </div>
                                <div class="login_error_wrap" id="err_common" style="display:none;">
                                    <div class="error_message" style="width:90%">
                                        
                                    </div>
                                </div>
                                <div class="btn_login_wrap">

                                    <button type="submit" class="btn_login" id="log.login">
                                        <span class="btn_text">로그인</span>
                                    </button>

                                </div>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
            <ul class="find_wrap" id="find_wrap">

                <li><a target="_blank" href="https://nid.naver.com/user2/api/route?m=routePwInquiry&amp;lang=ko_KR" class="find_text">비밀번호 찾기</a></li>
                <li><a target="_blank" href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&amp;lang=ko_KR" class="find_text">아이디 찾기</a></li>
                <li><a target="_blank" href="https://nid.naver.com/user2/V2Join?m=agree&amp;lang=ko_KR&amp;domain=section.blog.naver.com" class="find_text">회원가입</a>
                </li>

            </ul>
            <!--배너-->
            <div id="gladbanner" class="banner_wrap"><div style="width: 100%; height: auto; margin: 0px auto; line-height: 0;"><iframe id="gladbanner_tgtLREC" frameborder="no" scrolling="no" tabindex="0" name="" title="AD" style="width: 100%; height: 147px; visibility: inherit; border: 0px; vertical-align: bottom;" sandbox="allow-forms allow-popups allow-popups-to-escape-sandbox allow-same-origin allow-scripts allow-top-navigation-by-user-activation" src="https://ssl.pstatic.net/tveta/libs/glad/prod/2.22.1/res/r.html"></iframe></div></div>
        </div>
        <!-- //content -->
    </div>

    <!-- footer -->
    <div class="footer">
        <div class="footer_inner">
            <!--[주]고객센터,제휴문의,서비스안내-->
            <ul class="footer_link" id="footer_link">
                <li><a target="_blank" class="footer_item" href="http://www.naver.com/rules/service.html" id="fot.agreement"><span class="text">이용약관</span></a></li>
                <li><a target="_blank" class="footer_item" href="http://www.naver.com/rules/privacy.html" id="fot.privacy"><span class="text"><strong>개인정보처리방침</strong></span></a></li>
                <li><a target="_blank" class="footer_item" href="http://www.naver.com/rules/disclaimer.html" id="fot.disclaimer"><span class="text">책임의 한계와 법적고지</span></a></li>
                <li><a target="_blank" class="footer_item" href="https://help.naver.com/alias/membership/p.membership/main.naver" id="fot.help"><span class="text">회원정보 고객센터</span></a></li>
            </ul>
            <div class="footer_copy">
                <a id="fot.naver" target="_blank" href="https://www.navercorp.com">
                    <span class="footer_logo"><span class="blind">네이버</span></span>
                </a>
                <span class="text">Copyright</span>
                <span class="corp">© NAVER Corp.</span>
                <span class="text">All Rights Reserved.</span>
            </div>
        </div>
    </div>

</div>
<input type="hidden" id="nclicks_nsc" name="nclicks_nsc" value="nid.login_kr">
<input type="hidden" id="nid_buk" name="nid_buk" value="exist">
<input type="hidden" id="removeLink" name="removeLink" value="">
<input type="hidden" id="hide_util" name="hide_util" value="">
<input type="hidden" id="ncaptchaSplit" name="ncaptchaSplit" value="none">
<input type="hidden" id="id_error_msg" name="id_error_msg" value="<strong>아이디</strong>를 입력해주세요.">
<input type="hidden" id="pw_error_msg" name="pw_error_msg" value="<strong>비밀번호</strong>를 입력해주세요.">
<input type="hidden" id="locale" name="locale" value="ko_KR">
<input type="hidden" id="adult_surl_v2" name="adult_surl_v2" value="">
<input type="hidden" id="ispopup" name="ispopup" value="false">
<script type="text/javascript" src="/login/js/bvsd.1.3.9.min.js"></script>
<script type="text/javascript" async="" src="https://ssl.pstatic.net/tveta/libs/glad/prod/gfp-core.js"></script>
<script type="text/javascript" src="/login/js/v2/default/common_202201.js?v=20230619"></script>
<script type="text/javascript" src="/login/js/v2/default/default_202105.js?v=20230217"></script>
<div id="nv_stat" style="display:none;">20</div>


</body>
</html>