$(document).ready(function () {

    $('#toggle_pwd').click(function () {
        $(this).toggleClass('fa-eye fa-eye-slash');
        var type = $(this).hasClass('fa-eye') ? 'text' : 'password';
        $('#password').attr('type', type);
    });

    $('#toggle_conf_pwd').click(function () {
        $(this).toggleClass('fa-eye fa-eye-slash');
        var type = $(this).hasClass('fa-eye') ? 'text' : 'password';
        $('#confirmPassword').attr('type', type);
    });

    $('.table .editBtn').on('click', function(e) {
        e.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(resp) {
            $('.myForm #id').val(resp.id);
            $('.myForm #orderNo').val(resp.orderNo);
            $('.myForm #clientTin').val(resp.clientTin);
            $('.myForm #deviceNo').val(resp.deviceNo);
            $('.myForm #link').val(resp.link);
            $('.myForm #date').val(resp.date);
            $('.myForm #status').val(resp.status);
        });
        $('.myForm #updateModal').modal();
    });
});
