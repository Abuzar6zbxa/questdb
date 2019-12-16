/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2020 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.cairo;

import io.questdb.cutlass.text.DefaultTextConfiguration;
import io.questdb.cutlass.text.TextConfiguration;
import io.questdb.std.Chars;
import io.questdb.std.FilesFacade;
import io.questdb.std.FilesFacadeImpl;
import io.questdb.std.Numbers;
import io.questdb.std.microtime.MicrosecondClock;
import io.questdb.std.microtime.MicrosecondClockImpl;
import io.questdb.std.time.MillisecondClock;
import io.questdb.std.time.MillisecondClockImpl;

public class DefaultCairoConfiguration implements CairoConfiguration {

    private final CharSequence root;
    private final TextConfiguration textConfiguration = new DefaultTextConfiguration();

    public DefaultCairoConfiguration(CharSequence root) {
        this.root = Chars.stringOf(root);
    }

    @Override
    public int getCreateAsSelectRetryCount() {
        return 5;
    }

    @Override
    public CharSequence getDefaultMapType() {
        return "fast";
    }

    @Override
    public boolean getDefaultSymbolCacheFlag() {
        return true;
    }

    @Override
    public int getDefaultSymbolCapacity() {
        return 128;
    }

    @Override
    public int getFileOperationRetryCount() {
        return 30;
    }

    @Override
    public FilesFacade getFilesFacade() {
        return FilesFacadeImpl.INSTANCE;
    }

    @Override
    public long getIdleCheckInterval() {
        return 100;
    }

    @Override
    public long getInactiveReaderTTL() {
        return -10000;
    }

    @Override
    public long getInactiveWriterTTL() {
        return -10000;
    }

    @Override
    public int getIndexValueBlockSize() {
        return 256;
    }

    @Override
    public int getMaxSwapFileCount() {
        return 30;
    }

    @Override
    public MicrosecondClock getMicrosecondClock() {
        return MicrosecondClockImpl.INSTANCE;
    }

    @Override
    public MillisecondClock getMillisecondClock() {
        return MillisecondClockImpl.INSTANCE;
    }

    @Override
    public int getMkDirMode() {
        return 509;
    }

    @Override
    public int getParallelIndexThreshold() {
        return 100000;
    }

    @Override
    public int getReaderPoolMaxSegments() {
        return 5;
    }

    @Override
    public CharSequence getRoot() {
        return root;
    }

    @Override
    public long getSpinLockTimeoutUs() {
        return 1000000;
    }

    @Override
    public int getSqlCacheBlocks() {
        return 4;
    }

    @Override
    public int getSqlCacheRows() {
        return 16;
    }

    @Override
    public int getSqlCharacterStoreCapacity() {
        // 1024 seems like a good fit, but tests need
        // smaller capacity so that resize is tested correctly
        return 64;
    }

    @Override
    public int getCommitMode() {
        return CommitMode.NOSYNC;
    }

    @Override
    public int getSqlCharacterStoreSequencePoolCapacity() {
        return 64;
    }

    @Override
    public int getSqlColumnPoolCapacity() {
        return 4096;
    }

    @Override
    public double getSqlCompactMapLoadFactor() {
        return 0.8;
    }

    @Override
    public int getSqlExpressionPoolCapacity() {
        return 8192;
    }

    @Override
    public double getSqlFastMapLoadFactor() {
        return 0.5;
    }

    @Override
    public int getSqlJoinContextPoolCapacity() {
        return 64;
    }

    @Override
    public int getSqlLexerPoolCapacity() {
        return 2048;
    }

    @Override
    public int getSqlMapKeyCapacity() {
        return 128;
    }

    @Override
    public int getSqlMapPageSize() {
        return 16 * Numbers.SIZE_1MB;
    }

    @Override
    public int getSqlModelPoolCapacity() {
        return 1024;
    }

    @Override
    public int getSqlSortKeyPageSize() {
        return 4 * Numbers.SIZE_1MB;
    }

    @Override
    public int getSqlSortLightValuePageSize() {
        return Numbers.SIZE_1MB;
    }

    @Override
    public int getSqlHashJoinValuePageSize() {
        return Numbers.SIZE_1MB * 16;
    }

    @Override
    public long getSqlLatestByRowCount() {
        return 1000;
    }

    @Override
    public int getSqlHashJoinLightValuePageSize() {
        return Numbers.SIZE_1MB;
    }

    @Override
    public int getSqlSortValuePageSize() {
        return Numbers.SIZE_1MB * 16;
    }

    @Override
    public long getWorkStealTimeoutNanos() {
        return 10000;
    }

    @Override
    public boolean isParallelIndexingEnabled() {
        return true;
    }

    @Override
    public int getSqlJoinMetadataPageSize() {
        return 16 * 1024;
    }

    @Override
    public int getAnalyticColumnPoolCapacity() {
        return 64;
    }

    @Override
    public int getCreateTableModelPoolCapacity() {
        return 32;
    }

    @Override
    public int getColumnCastModelPoolCapacity() {
        return 32;
    }

    @Override
    public int getRenameTableModelPoolCapacity() {
        return 8;
    }

    @Override
    public int getWithClauseModelPoolCapacity() {
        return 128;
    }

    @Override
    public int getInsertPoolCapacity() {
        return 8;
    }

    @Override
    public int getCopyPoolCapacity() {
        return 16;
    }

    @Override
    public int getSqlCopyBufferSize() {
        return 1024 * 1024;
    }

    @Override
    public TextConfiguration getTextConfiguration() {
        return textConfiguration;
    }
}