package mcp.mobius.waila.api.event;

import mcp.mobius.waila.api.ICommonAccessor;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.chat.Component;

import java.util.List;

/**
 * This event is fired just before the Waila tooltip sizes are calculated. This is the last chance to make edits to
 * the information being displayed.
 * <p>
 * This event is not cancelable.
 * <p>
 * {@link #currentTip} - The current tooltip to be drawn.
 */
public class WailaTooltipEvent {

    public static final Event<HandleTooltip> WAILA_HANDLE_TOOLTIP = EventFactory.createArrayBacked(HandleTooltip.class,
            listeners -> event -> {
                for (HandleTooltip listener : listeners)
                    listener.onTooltip(event);
            }
    );

    private final List<Component> currentTip;
    private final ICommonAccessor accessor;

    public WailaTooltipEvent(List<Component> currentTip, ICommonAccessor accessor) {
        this.currentTip = currentTip;
        this.accessor = accessor;
    }

    public List<Component> getCurrentTip() {
        return currentTip;
    }

    public ICommonAccessor getAccessor() {
        return accessor;
    }

    public interface HandleTooltip {
        void onTooltip(WailaTooltipEvent event);
    }
}
