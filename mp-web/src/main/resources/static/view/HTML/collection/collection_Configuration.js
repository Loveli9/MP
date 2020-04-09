; $(function () {
    var projectId = 16043;
    var id;
    var collectionFields;
    var all_data_message;
    var tab_index;
    $.ajax({
        contentType: "application/x-www-form-urlencoded", //设置请求头信息
        url: getRootPath() + "/datacollection/config/collection_config/get_by_project_id",
        type: 'post',
        method: 'post',
        async: false,
        data: { projectId: projectId },
        success: function (res) {
            all_data_message = res;
            id = res.id
            var change_tab = res.collectionGroups;
            var htmlFragment = '';
            var appendHtml = '';
            $(".mtm-tabs").empty();
            for (let i = 0; i < change_tab.length; i++) {
                if (i == 0) {
                    htmlFragment = `<li role="presentation" collectionGroups=${change_tab[i].metricsTableConfigId} class="active"><a href="#">${change_tab[i].metricsTableConfig.alias}</a></li>`;
                    appendHtml += htmlFragment;
                    collectionFields = change_tab[i].collectionFields;
                    collect_config_initPage(change_tab[i].collectionFields, i)
                    tab_index = i;
                } else {
                    htmlFragment = `<li role="presentation" collectionGroups=${change_tab[i].metricsTableConfigId}><a href="#">${change_tab[i].metricsTableConfig.alias}</a></li>`;
                    appendHtml += htmlFragment;
                    collect_config_initPage(change_tab[i].collectionFields, i)
                }
            }
            $(".mtm-tabs").append(appendHtml);

        }
    });

    //tab切换
    $(".mtm-tabs").on("click", "li", function () {
        $(this).addClass("active").siblings('li').removeClass("active");
        var click_index = $(this).index()
        collectionFields = all_data_message.collectionGroups[click_index].collectionFields;
        $(`.tab_change${click_index}`).attr("style", "display=block")
        $(`.tab_change${click_index}`).siblings().attr("style", "display=none");
        tab_index = click_index;
    });

    $(".collection_type").on("change", function () {
        console.log(1)
        if ($(this).val() == "1") {
            $(this).parent().next().children().attr("disabled", true);
            $(this).parent().next().children().val("")
        } else {
            $(this).parent().next().children().attr("disabled", false)
        }
    })

    //保存
    $("#collection_Configuration_save_btn").on("click", function () {
        for (let i = 0; i < collectionFields.length; i++) {
            collectionFields[i].inputType = $(`.collection_type${i}`).val();
            collectionFields[i].collectionTaskId = $(`.collection_task${i}`).val();
        }
        all_data_message.collectionGroups[tab_index].collectionFields = collectionFields
        var params = {
            id: id,
            projectId: all_data_message.projectId,
            metricsTableConfigId: $(".active").attr("collectionGroups"),
            collectionGroups: all_data_message.collectionGroups,
        }
        $.ajax({
            contentType: "application/json;charset=utf-8", //设置请求头信息
            url: getRootPath() + "/datacollection/config/collection_config/saveCollectionConfig",
            type: 'post',
            method: 'post',
            data: JSON.stringify(params),
            success: function (res) {
                if (res.code == 200) {
                    window.top.toastr.success('修改成功！');
                    setTimeout(function () { location.reload(); }, 1000);
                }
            }
        });
    });
    $(document).ready(function () {
        for (let i = 0; i < collectionFields.length; i++) {
            $(`.collection_type${i}`).val(collectionFields[i].inputType);
            $(`.collection_task${i}`).val(collectionFields[i].collectionTaskId);
            if (collectionFields[i].inputType == 1) {
                $(`.collection_task${i}`).attr("disabled", true);
                $(`.collection_task${i}`).val("");
            }
        }
    })
});
function collect_config_initPage(paramster, index) {
    $("#interfaceEditForm").empty();
    var formList = ""
    for (let i = 0; i < paramster.length; i++) {
        formList +=
            `<div class="form-group col-md-6">
            <div class="col-md-6">
                <label for="type" control-label">${paramster[i].metricsItemConfig.fieldAlias}</label>
                <select class="form-control collection_type collection_type${i}" name="type" style="padding-right: 0px">
                    <option value="1">手录</option>
                    <option value="2">采集</option>
                    <option value="3">手录+采集</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="type" control-label">采集任务</label>
                <select class="form-control collection_task collection_task${i}"" name="type" style="padding-right: 0px">
                    <option value="任务1">任务1</option>
                    <option value="任务2">任务2</option>
                    <option value="任务3">任务3</option>
                </select>
            </div>
        </div>`
    }
    var append_html;
    if (index == 0) {
        append_html = `<div class=tab_change${index}>` + formList + "</div>"
    } else {
        append_html = `<div style="display:none" class=tab_change${index}>` + formList + "</div>"
    }
    $("#interfaceEditForm").append(append_html);
    $(".collection_task").val("")
};