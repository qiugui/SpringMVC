$(document).ready(function () {

           $('.easyui-accordion li a').click(function () {

               var tabTitle = $(this).text();

               var url = $(this).attr("href");

               addTab(tabTitle, url);

               $('.easyui-accordion li div').removeClass("selected");

               $(this).parent().addClass("selected");

           }).hover(function () {

               $(this).parent().addClass("hover");

           }, function () {

               $(this).parent().removeClass("hover");

           });

		   
		   function addTab(subtitle, url) {

               if (!$('#tabs').tabs('exists', subtitle)) {

                   $('#tabs').tabs('add', {

                       title: subtitle,

                       content: createFrame(url),

                       closable: true,

                       width: $('#mainPanle').width() - 10,

                       height: $('#mainPanle').height() - 26

                   });

               } else {

                   $('#tabs').tabs('select', subtitle);

              }

               tabClose();

           }


           function createFrame(url) {

               var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';

               return s;

           }

 
           function tabClose() {

               /*˫���ر�TABѡ�*/

               $(".tabs-inner").dblclick(function () {

                   var subtitle = $(this).children("span").text();

                   $('#tabs').tabs('close', subtitle);

               })

 

               $(".tabs-inner").bind('contextmenu', function (e) {

                   $('#mm').menu('show', {

                       left: e.pageX,

                       top: e.pageY,

                   });

                   var subtitle = $(this).children("span").text();

                   $('#mm').data("currtab", subtitle);

                   return false;

               });

           }

 

           //���Ҽ��˵��¼�

			function tabCloseEven() {

               //�رյ�ǰ

				$('#mm-tabclose').click(function () {

                   var currtab_title = $('#mm').data("currtab");

                   $('#tabs').tabs('close', currtab_title);

               })

               //ȫ���ر�

				$('#mm-tabcloseall').click(function () {

                   $('.tabs-inner span').each(function (i, n) {

                       var t = $(n).text();

                      $('#tabs').tabs('close', t);

                   });

               });

 

               //�رճ���ǰ֮���TAB

               $('#mm-tabcloseother').click(function () {

                   var currtab_title = $('#mm').data("currtab");

                   $('.tabs-inner span').each(function (i, n) {

                       var t = $(n).text();

                       if (t != currtab_title)

                           $('#tabs').tabs('close', t);

                   });

               });

               //�رյ�ǰ�Ҳ��TAB

               $('#mm-tabcloseright').click(function () {

                   var nextall = $('.tabs-selected').nextAll();

                   if (nextall.length == 0) {

                      //msgShow('ϵͳ��ʾ','���û����~~','error');

                       alert('���û����~~');

                       return false;

                   }

                   nextall.each(function (i, n) {

                       var t = $('a:eq(0) span', $(n)).text();

                       $('#tabs').tabs('close', t);

                   });

                   return false;

              });

               //�رյ�ǰ����TAB

               $('#mm-tabcloseleft').click(function () {

                   var prevall = $('.tabs-selected').prevAll();

                   if (prevall.length == 0) {

                       alert('��ͷ�ˣ�ǰ��û����~~');

                       return false;

                   }

                   prevall.each(function (i, n) {

                       var t = $('a:eq(0) span', $(n)).text();

                       $('#tabs').tabs('close', t);

                   });

                   return false;

               });

 

               //�˳�

               $("#mm-exit").click(function () {

                   $('#mm').menu('hide');

 

               })

           }

       });