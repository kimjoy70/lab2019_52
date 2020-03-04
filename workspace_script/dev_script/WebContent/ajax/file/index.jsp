<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<input type="file" id="fileupload">
<button id="uploadClick">���� ���ε�</button>
<span id="progress"></span>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
  $('#uploadClick').on('click', function() {
    var file = $("#fileupload")[0].files[0];
    var filename = file.name;
    var reader = new FileReader();
    reader.onload = function(e) {
      // ��ȯ�� ������ reader.result�� �ɴϴ�.
      var base64data = reader.result;
      console.log(base64data);
      // ���⼭ ������ �߿��մϴ�.
      // ������ ��data: ���� Ÿ��; base64, �����͡��Դϴ�.
      var data = base64data.split(',')[1];
      //data�� ���� ������ �Դϴ�.
      //��� ajax�� �ѱ涧�� ū ������ �����ؼ� �����͸� �ѱ�� ������ �Ǵµ� 
      //�����̴ٺ��� ���α׷����� ������ ��Ÿ���� ���� ���� 1�� ������ �����ڽ��ϴ�.
      var sendsize = 1024;
      var filelength = data.length;
      var pos = 0;
      var upload = function() {
        $.ajax({
          type : 'POST',
          dataType : 'json',
          data : {
            filename : filename,
            filelength : filelength,
            filepos : pos,
            data : data.substring(pos, pos + sendsize)
          },
          url : './upload',
          success : function(data) {
            // ��ü�� ���۵� ������
            if (pos < filelength) {
              // ���
              setTimeout(upload, 1);
            }
            pos = pos + sendsize;
            if (pos > filelength) {
              pos = filelength;
            }
            $('#progress').text(pos + ' / ' + filelength);
          },
          error : function(jqXHR, textStatus, errorThrown) {
          },
          complete : function(jqXHR, textStatus) {
          }
        });
      };
      setTimeout(upload, 1);
    }
    // base64�� �ѱ�ϴ�.
    reader.readAsDataURL(file);
  });
</script>
</body>
</html>