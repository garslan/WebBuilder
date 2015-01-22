$(document).ready(function() {
    $( ".widget" ).draggable({
        appendTo: "body",
        helper: "clone"
    });

    $( "#platform ol" ).droppable({
        activeClass: "ui-state-default",
        hoverClass: "ui-state-hover",
        accept: ":not(.ui-sortable-helper)",
        drop: function( event, ui ) {
            var text = ui.draggable.text().trim();
            var widgetName = text.substring(0, text.lastIndexOf(" ")).trim();
            var widgetId = text.substring(widgetName.length, text.length).trim();

            $( this ).find( ".placeholder" ).remove();
            $('<li><div><a class="droppedWidget" \'>' + widgetName + '</a><p hidden="true">'+ widgetId +'</p></div></li>').appendTo( this );
           // $('<li><div><a class="droppedWidget" onclick=\'getSettings(' + widgetId + ')\'>' + widgetName + '</a><p hidden="true">'+ widgetId +'</p></div></li>').appendTo( this );
        }
    }).sortable({
        items: "li:not(.placeholder)",
        sort: function() {
            $( this ).removeClass( "ui-state-default" );
        }
    });

    $('.droppedWidget').click( function() {
        alert( this.text() ); // jQuery позаботится о том, чтобы 'this' являлась кнопкой
    });



});

function getSettings(widgetId){
    return alert(widgetId);
}

